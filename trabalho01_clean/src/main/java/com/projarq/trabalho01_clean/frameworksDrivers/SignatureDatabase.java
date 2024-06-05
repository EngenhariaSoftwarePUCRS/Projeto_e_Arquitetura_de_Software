package com.projarq.trabalho01_clean.frameworksDrivers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.Signature.SignatureType;
import com.projarq.trabalho01_clean.interfaceAdaptors.repository.ISignatureRepository;
import com.projarq.trabalho01_clean.domain.entity.SignatureEntity;

@Repository
public class SignatureDatabase implements ISignatureRepository {
    private JdbcTemplate database;

    @Autowired
    public SignatureDatabase(JdbcTemplate database) {
        this.database = database;
    }

    @Override
    public SignatureEntity addSignature(Long clientId, Long appId, Date startDate) {
        String sql = "INSERT INTO signatures (clientId, appId, startDate) VALUES (?, ?, ?)";
        int signatureDBId = database.update(sql, clientId, appId, startDate);
        Long signatureId = Long.valueOf(signatureDBId);
        return getSignature(signatureId);
    }

    @Override
    public SignatureEntity getSignature(Long signatureId) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM signatures WHERE id = ?";
        return database.queryForObject(sql, (rs, rowNum) -> new SignatureEntity(
            rs.getLong("id"),
            rs.getLong("appId"),
            rs.getLong("clientId"),
            rs.getDate("startDate"),
            rs.getDate("endDate")
        ), signatureId);
    }

    @Override
    public List<SignatureEntity> getAppSignatures(Long appId) {
        String sql = "SELECT * FROM signatures WHERE appId = ?";
        return database.query(sql, (rs, rowNum) -> new SignatureEntity(
            rs.getLong("id"),
            rs.getLong("appId"),
            rs.getLong("clientId"),
            rs.getDate("startDate"),
            rs.getDate("endDate")
        ));
    }

    @Override
    public List<SignatureEntity> getClientSignatures(Long clientID) {
        String sql = "SELECT * FROM signatures WHERE clientId = ?";
        return database.query(sql, (rs, rowNum) -> new SignatureEntity(
            rs.getLong("id"),
            rs.getLong("appId"),
            rs.getLong("clientId"),
            rs.getDate("startDate"),
            rs.getDate("endDate")
        ));
    }

    @Override
    public List<SignatureEntity> getSignatureByType(Long appId, SignatureType type) {
        String sql = "SELECT * FROM signatures WHERE appId = ? AND type = ?";
        return database.query(sql, (rs, rowNum) -> new SignatureEntity(
            rs.getLong("id"),
            rs.getLong("appId"),
            rs.getLong("clientId"),
            rs.getDate("startDate"),
            rs.getDate("endDate")
        ), appId, type);
    }
}
