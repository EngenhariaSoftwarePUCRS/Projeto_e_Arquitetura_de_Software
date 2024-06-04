package com.projarq.trabalho01_clean.interfaceAdaptors.useCases;

import java.util.List;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;

public interface ISignatureUseCases {
    SignatureResponse addSignature (Long clientId, Long appId);
    List<SignatureResponse> getClientSignatures(Long clientID);
    List<SignatureResponse> getSignatureByType(Long appId, SignatureType type);
    List<SignatureResponse> getAppSignatures(Long appId);
    boolean isSignatureActive(Long signatureId);
}