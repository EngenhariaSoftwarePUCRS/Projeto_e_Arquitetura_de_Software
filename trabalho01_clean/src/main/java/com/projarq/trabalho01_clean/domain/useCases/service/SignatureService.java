package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IAppUseCases;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IClientUseCases;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.ISignatureUseCases;
import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;

@Service
public class SignatureService implements ISignatureUseCases {
    private IAppUseCases appService;
    private IClientUseCases clientService;
    private ISignatureRepository signatureRepository;

    @Autowired
    public SignatureService(
        IAppUseCases appService,
        IClientUseCases clientService,
        ISignatureRepository signatureRepository
    ) {
        this.appService = appService;
        this.clientService = clientService;
        this.signatureRepository = signatureRepository;
    }

    @Override
    public SignatureResponse addSignature(Long clientId, Long appId) throws IllegalArgumentException {
        ClientEntity client = clientService.getClient(clientId);
        AppEntity app = appService.getApp(appId);
        if (client == null) {
            throw new IllegalArgumentException("Client not found");
        }
        if (app == null) {
            throw new IllegalArgumentException("App not found");
        }
        SignatureEntity signature = signatureRepository.addSignature(clientId, appId, new Date());
        return new SignatureResponse(
            signature.getId(),
            signature.getAppId(),
            signature.getClientId(),
            signature.getStartDate(),
            signature.getEndDate()
        );
    }

    @Override
    public SignatureResponse getSignature(Long signatureId) throws EmptyResultDataAccessException {
        SignatureEntity signature = signatureRepository.getSignature(signatureId);
        return new SignatureResponse(
            signature.getId(),
            signature.getAppId(),
            signature.getClientId(),
            signature.getStartDate(),
            signature.getEndDate()
        );
    }

    @Override
    public List<SignatureResponse> getAppSignatures(Long appId) {
        List<SignatureEntity> signatures = signatureRepository.getAppSignatures(appId);
        return signatures.stream().map(signature -> {
            return new SignatureResponse(
                signature.getId(),
                signature.getAppId(),
                signature.getClientId(),
                signature.getStartDate(),
                signature.getEndDate()
            );
        }).toList();
    }

    @Override
    public List<SignatureResponse> getClientSignatures(Long clientID) {
        List<SignatureEntity> signatures = signatureRepository.getClientSignatures(clientID);
        return signatures.stream().map(signature -> {
            return new SignatureResponse(
                signature.getId(),
                signature.getAppId(),
                signature.getClientId(),
                signature.getStartDate(),
                signature.getEndDate()
            );
        }).toList();
    }

    @Override
    public List<SignatureResponse> getSignatureByType(Long appId, SignatureType type) {
        List<SignatureEntity> signatures = signatureRepository.getSignatureByType(appId, type);
        return signatures.stream().map(signature -> {
            return new SignatureResponse(
                signature.getId(),
                signature.getAppId(),
                signature.getClientId(),
                signature.getStartDate(),
                signature.getEndDate()
            );
        }).toList();
    }

    @Override
    public boolean isSignatureActive(Long signatureId) {
        SignatureEntity signature = signatureRepository.getSignature(signatureId);
        return signature.getEndDate() == null;
    }
}
