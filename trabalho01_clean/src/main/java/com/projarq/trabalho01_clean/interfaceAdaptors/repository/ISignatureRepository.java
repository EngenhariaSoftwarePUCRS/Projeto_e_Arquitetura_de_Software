package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.Date;
import java.util.List;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;

public interface ISignatureRepository {
    SignatureEntity addSignature (Long clientId, Long appId, Date startDate);
    SignatureEntity getSignature(Long signatureId);
    List<SignatureEntity> getClientSignatures(Long clientID);
    List<SignatureEntity> getSignatureByType(Long appId, SignatureType type);
    List<SignatureEntity> getAppSignatures(Long appId);
}