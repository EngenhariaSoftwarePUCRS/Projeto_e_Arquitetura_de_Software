package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import java.util.List;

import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;
import com.projarq.trabalho01_clean.domain.repository.ISignatureRepository;

public class SignatureRepository implements ISignatureRepository {

    @Override
    public SignatureEntity addSignature(Long clientId, Long appId) {
        return null;
    }

    @Override
    public List<SignatureEntity> getAppSignatures(Long appId) {
        return null;
    }

    @Override
    public List<SignatureEntity> getClientSignatures(Long clientID) {
        return null;
    }

    @Override
    public List<SignatureEntity> getSignatureByType(Long appId, String type) {
        return null;
    }

    @Override
    public boolean isSignatureActive(Long signatureId) {
        return false;
    }
}
