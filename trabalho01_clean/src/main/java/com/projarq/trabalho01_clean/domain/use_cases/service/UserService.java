package com.projarq.trabalho01_clean.domain.use_cases.service;

import org.springframework.context.annotation.Primary;

import com.projarq.trabalho01_clean.interfaceAdaptors.repository.IUserRepository;

@Primary
public class UserService implements IUserRepository {
}
