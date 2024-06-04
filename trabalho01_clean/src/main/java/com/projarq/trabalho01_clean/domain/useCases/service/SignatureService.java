package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.ISignatureUseCases;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;

@Service
public class SignatureService implements ISignatureUseCases {
    private ISignatureRepository signatureRepository;

    @Autowired
    public SignatureService(ISignatureRepository signatureRepository) {
        this.signatureRepository = signatureRepository;
    }

    @Override
    public SignatureResponse addSignature(Long clientId, Long appId) {
        return signatureRepository.addSignature(clientId, appId);
    }

    @Override
    public List<SignatureResponse> getAppSignatures(Long appId) {
        return signatureRepository.getAppSignatures(appId);
    }

    @Override
    public List<SignatureResponse> getClientSignatures(Long clientID) {
        return signatureRepository.getClientSignatures(clientID);
    }

    @Override
    public List<SignatureResponse> getSignatureByType(Long appId, SignatureType type) {
        return signatureRepository.getSignatureByType(appId, type);
    }

    @Override
    public boolean isSignatureActive(Long signatureId) {
        return signatureRepository.isSignatureActive(signatureId);
    }
    
}
