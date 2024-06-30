package com.projarq.asscache.service;

import com.projarq.asscache.model.Signature;
import com.projarq.asscache.repository.SignatureRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SignatureService {
    @Autowired
    private SignatureRepository signatureRepository;

    public boolean isSignatureActive(Long appId) {
        Optional<Signature> signatureOpt = signatureRepository.findByAppId(appId);
        if (signatureOpt.isPresent()) {
            Signature signature = signatureOpt.get();
            if (signature.getExpiryDate().isAfter(LocalDateTime.now())) {
                return signature.isActive();
            }
        }
        // Se não encontrar no cache, consulta o SCAA
        // Código para consultar o SCAA e armazenar no cache
        return false;
    }

    @RabbitListener(queues = "signature.update.queue")
    public void handleSignatureUpdate(String message) {
        Long appId = Long.parseLong(message);
        signatureRepository.deleteByAppId(appId);
    }
}
