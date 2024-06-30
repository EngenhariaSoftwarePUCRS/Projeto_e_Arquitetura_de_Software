package com.projarq.asscache.controller;

import com.projarq.asscache.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignatureController {
    @Autowired
    private SignatureService signatureService;

    @GetMapping
    public String welcome() {
        return "AssCache: Signature Controller";
    }

    @GetMapping("/assinvalida/{codapp}")
    public boolean isSignatureActive(@PathVariable("codapp") Long appId) {
        return signatureService.isSignatureActive(appId);
    }
}
