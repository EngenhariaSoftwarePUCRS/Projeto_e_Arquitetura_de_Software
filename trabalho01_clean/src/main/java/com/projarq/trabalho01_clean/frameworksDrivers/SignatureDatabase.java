package com.projarq.trabalho01_clean.frameworksDrivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureResponse;

@Repository
public class SignatureDatabase implements ISignatureRepository {
    private JdbcTemplate database;

    @Autowired
    public SignatureDatabase(JdbcTemplate database) {
        this.database = database;
    }

    @Override
    public SignatureResponse addSignature(Long clientId, Long appId) {
        return null;
    }

    @Override
    public List<SignatureResponse> getAppSignatures(Long appId) {
        return null;
    }

    @Override
    public List<SignatureResponse> getClientSignatures(Long clientID) {
        return null;
    }

    @Override
    public List<SignatureResponse> getSignatureByType(Long appId, SignatureType type) {
        return null;
    }

    @Override
    public boolean isSignatureActive(Long signatureId) {
        return false;
    }
}
