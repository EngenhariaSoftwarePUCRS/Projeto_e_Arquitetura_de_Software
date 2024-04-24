package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;
import com.projarq.trabalho01_clean.domain.repository.ISignatureRepository;

@RestController
public class SignatureController {
    private ISignatureRepository signatureRepository;

    public SignatureController() {
    
    }

    @PostMapping("/servcad/assinaturas") // Cria uma assinatura
    @CrossOrigin(origins = "*")
    public SignatureEntity addSignature(@RequestBody final Long clientId, @RequestBody final Long appId) {
        return signatureRepository.addSignature(clientId, appId);
    }

    @GetMapping("/servcad/asscli/:codcli") // Retorna a lista das assinaturas do cliente informado
    @CrossOrigin(origins = "*")
    public List<SignatureEntity> getClientSignatures(@RequestBody final Long clientId) {
        return signatureRepository.getClientSignatures(clientId);
    }

    @GetMapping("/servcad/assapp/{tipo}") // Retorna a lista de assinaturas de um aplicativo
    @CrossOrigin(origins = "*")
    public List<SignatureEntity> getSignatureByType(
        @RequestBody final Long appId,
        @PathVariable(value="tipo") String type
    ) {
        return signatureRepository.getSignatureByType(appId, type);
    }

    @GetMapping("/servcad/assapp/:codapp") // Retorna se a assinatura questionada permanece ativa
    @CrossOrigin(origins = "*")
    public boolean isSignatureActive(@RequestBody final Long signatureId) {
        return signatureRepository.isSignatureActive(signatureId);
    }
}