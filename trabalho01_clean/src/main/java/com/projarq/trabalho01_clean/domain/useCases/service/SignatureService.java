package com.projarq.trabalho01_clean.domain.useCases.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IAppUseCases;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IClientUseCases;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.ISignatureUseCases;
import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.entity.ClientEntity;
import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;

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
        ClientEntity client;
        try {
            client = clientService.getClient(clientId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Client not found");
        }
        if (client == null) {
            throw new IllegalArgumentException("Client not found");
        }

        AppEntity app;
        try {
            app = appService.getApp(appId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("App not found");
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
    public List<SignatureResponse> getAllSignatures() {
        List<SignatureEntity> signatures = signatureRepository.getAllSignatures();
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
    public SignatureResponse getSignature(Long signatureId) throws IllegalArgumentException {
        SignatureEntity signature;
        try {
            signature = signatureRepository.getSignature(signatureId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Signature not found");
        }
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
        List<SignatureEntity> signatures;
        try {
            signatures = signatureRepository.getClientSignatures(clientID);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Client not found");
        }
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
    public List<SignatureResponse> getSignatureByType(SignatureType type) {
        List<SignatureEntity> signatures = null;
        Boolean isEndDateNull = null;
        if (type == SignatureType.TODAS) {
            isEndDateNull = null;
        } else if (type == SignatureType.ATIVAS) {
            isEndDateNull = true;
        } else if (type == SignatureType.CANCELADAS) {
            isEndDateNull = false;
        }
        signatures = signatureRepository.getSignatureByEndDate(isEndDateNull);
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
    public boolean isSignatureActive(Long signatureId) throws IllegalArgumentException {
        SignatureEntity signature;
        try {
            signature = signatureRepository.getSignature(signatureId);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Signature not found");
        }
        return signature.getEndDate() == null;
    }

    @Override
    public void cancelSignature(Long signatureId) throws IllegalArgumentException {
        try {
            signatureRepository.cancelSignature(signatureId, new Date());
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Signature not found");
        }
    }
}
