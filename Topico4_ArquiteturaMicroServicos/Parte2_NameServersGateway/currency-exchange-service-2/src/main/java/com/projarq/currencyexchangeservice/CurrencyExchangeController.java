package com.projarq.currencyexchangeservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private CurrencyExchangeRepository repository;
    private Environment environment;

    public CurrencyExchangeController(CurrencyExchangeRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @GetMapping
    public String index() {
        return "Currency Exchange Service";
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.info("retrieveExchangeValue called with from {} to {}", from, to);
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new ResourceNotFoundException("From " + from + "To " + to + " not found");
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        String operation = "from " + from + " to " + to;
        sendToInformationCollector(to, operation);
        return currencyExchange;
    }

    private void sendToInformationCollector(String currency, String operation) {
        logger.info("sendToInformationCollector called with currency {} and operation {}", currency, operation);
        String uri = "http://localhost:8080/information-collector/currency";
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("currency", currency);
        uriVariables.put("operation", operation);
        ResponseEntity<?> responseEntity = new RestTemplate().postForEntity(uri, uriVariables, null);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new ResourceNotFoundException("Currency " + currency + "Operation " + operation + " not found");
        }
    }
}
