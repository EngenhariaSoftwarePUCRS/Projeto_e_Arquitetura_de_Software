package com.projarq.asscache.controller;

import com.projarq.asscache.model.Signature;
import com.projarq.asscache.service.CacheService;
import com.projarq.asscache.service.SignatureService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class SignatureController {
    private SignatureService signatureService;
    private CacheService cacheService;
    private RestTemplate restTemplate;

    @Value("${scaa.url}")
    private String scaaUrl;

    @Autowired
    public SignatureController(
        SignatureService signatureService,
        CacheService cacheService,
        RestTemplate restTemplate
    ) {
        this.signatureService = signatureService;
        this.cacheService = cacheService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String welcome() {
        return "AssCache: Signature Controller";
    }

    @GetMapping("/assinvalida/{codapp}")
    public boolean isSignatureActive(@PathVariable("codapp") Long appId) {
        return signatureService.isSignatureActive(appId);
    }

    @GetMapping("/{signatureId}")
    public ResponseEntity<Signature> checkSignature(@PathVariable String signatureId) {
        System.out.println("Checking signature for signatureId: " + signatureId);
        System.out.println("\n\n\tSCAA URL: " + scaaUrl + "\n\n");
        Signature signature = cacheService.getSignature(signatureId);
        if (signature == null) {
            String path = scaaUrl + "/assinaturas/validade/" + signatureId;
            try {
                ResponseEntity<Date> response = restTemplate.getForEntity(path, Date.class);
                Date expiryDate = response.getBody();
                signature = new Signature(
                    Long.parseLong(signatureId),
                    expiryDate.after(new Date()),
                    expiryDate
                );
                System.out.println("Response: " + response);
            } catch (HttpClientErrorException e) {
                System.out.println("Error: " + e.getMessage());
                return ResponseEntity.notFound().build();
            }
            cacheService.updateCache(signature);
        }
        return ResponseEntity.ok(signature);
    }
}
