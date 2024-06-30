package com.projarq.asscache.repository;

import com.projarq.asscache.model.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
    Optional<Signature> findByAppId(Long appId);
    void deleteByAppId(Long appId);
}
