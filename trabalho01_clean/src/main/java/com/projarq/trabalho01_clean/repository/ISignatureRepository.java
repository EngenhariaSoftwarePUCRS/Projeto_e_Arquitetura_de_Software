package com.projarq.trabalho01_clean.repository;

import java.util.List;

import com.projarq.trabalho01_clean.entity.SignatureEntity;

public interface ISignatureRepository {
    SignatureEntity addSignature (Long clientId, Long appId);
    List<SignatureEntity> getClientSignatures(Long clientID);
    List<SignatureEntity> getSignatureByType(Long appId, String type);
    List<SignatureEntity> getAppSignatures(Long appId);
    boolean isSignatureActive(Long signatureId);
}