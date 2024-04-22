package com.projarq.trabalho01_clean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.entity.SignatureEntity;
import com.projarq.trabalho01_clean.repository.ISignatureRepository;

@Repository
public class SignatureService implements ISignatureRepository {
    private JdbcTemplate database;

    @Autowired
    public SignatureService(JdbcTemplate database) {
        this.database = database;
    }

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
