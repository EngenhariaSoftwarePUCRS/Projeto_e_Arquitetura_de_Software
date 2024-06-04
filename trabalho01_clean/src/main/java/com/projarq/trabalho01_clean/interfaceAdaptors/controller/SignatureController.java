package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureRequestDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;

@CrossOrigin(origins = "*")
@RestController
public class SignatureController {
    private ISignatureRepository signatureRepository;

    @Autowired
    public SignatureController(ISignatureRepository signatureRepository) {
        this.signatureRepository = signatureRepository;
    }

    /** Cria uma assinatura */
    @PostMapping("/servcad/assinaturas")
    public SignatureResponse addSignature(@RequestBody final SignatureRequestDTO signatureDTO) {
        return signatureRepository.addSignature(signatureDTO.getClientId(), signatureDTO.getAppId());
    }

    /** Retorna a lista com todas as assinaturas confirme o tipo */
    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<SignatureResponse> getSignatureByType(
        @RequestBody final Long appId,
        @PathVariable(value="tipo") String type
    ) {
        SignatureType signatureType = new SignatureType(type);
        return signatureRepository.getSignatureByType(appId, signatureType);
    }

    /** Retorna a lista das assinaturas do cliente informado */
    @GetMapping("/servcad/asscli/{codcli}")
    public List<SignatureResponse> getClientSignatures(
        @PathVariable(value="codcli") final Long clientId
    ) {
        return signatureRepository.getClientSignatures(clientId);
    }

    /** Retorna a lista de assinaturas de um aplicativo */
    @GetMapping("/servcad/assapp/{codapp}")
    public List<SignatureResponse> getAppSignatures(
        @PathVariable(value="codapp") final Long appId
    ) {
        return signatureRepository.getAppSignatures(appId);
    }

    /** Retorna se a assinatura questionada permanece ativa */
    @GetMapping("/assinvalida/{codass}")
    public boolean isSignatureActive(
        @PathVariable(value="codass") final Long signatureId
    ) {
        return signatureRepository.isSignatureActive(signatureId);
    }
}