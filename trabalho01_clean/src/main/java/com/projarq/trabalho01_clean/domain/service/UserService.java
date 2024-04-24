package com.projarq.trabalho01_clean.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.trabalho01_clean.domain.repository.IUserRepository;

@Repository
public class UserService implements IUserRepository {
    private JdbcTemplate database;

    @Autowired
    public UserService(JdbcTemplate database) {
        this.database = database;
    }
}
