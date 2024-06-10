package com.projarq.information_collector;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationCollectorController {
    private Logger logger = LoggerFactory.getLogger(InformationCollectorController.class);
    private InformationCollectorRepository repository;

    public InformationCollectorController(InformationCollectorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index() {
        return "Information Collector Service";
    }

    @GetMapping("/information-collector/currency")
    public Iterable<InformationCollector> getCurrencyInformation() {
        logger.info("getCurrencyInformation called");
        return repository.findAll();
    }

    @PostMapping("/information-collector/currency")
    public InformationCollector collectCurrencyInformation(Map<String, String> body) {
        String currency = body.get("currency");
        String operation = body.get("operation");
        logger.info("collectCurrencyInformation called with currency {} and operation {}", currency, operation);
        Long timestamp = new Date().getTime();
        InformationCollector information = new InformationCollector(0l, currency, operation, timestamp);
        InformationCollector informationCollector = repository.save(information);
        if (informationCollector == null) {
            throw new ResourceNotFoundException("Currency " + currency + "Operation " + operation + " not found");
        }
        return informationCollector;
    }
}
