package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.Date;
import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;

public interface ISignatureRepository {
    SignatureEntity addSignature (Long clientId, Long appId, Date startDate);
    List<SignatureEntity> getAllSignatures();
    SignatureEntity getSignature(Long signatureId);
    List<SignatureEntity> getClientSignatures(Long clientID);
    List<SignatureEntity> getSignatureByEndDate(Long appId, boolean endDateNull);
    List<SignatureEntity> getAppSignatures(Long appId);
}