package com.projarq.trabalho01_clean.interfaceAdaptors.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
    private JdbcTemplate database;

    @Autowired
    public UserRepository(JdbcTemplate database) {
        this.database = database;
    }
}
