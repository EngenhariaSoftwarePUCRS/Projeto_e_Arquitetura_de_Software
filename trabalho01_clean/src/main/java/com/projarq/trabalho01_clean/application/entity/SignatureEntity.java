package com.projarq.trabalho01_clean.application.entity;

import java.time.LocalDate;

import com.projarq.trabalho01_clean.application.entity.AppEntity;
import com.projarq.trabalho01_clean.application.entity.ClientEntity;

public class SignatureEntity {

    //Código da assinatura
    private Long id;
    //Aplicativo de que trata a assinatura
    private AppEntity app;
    //Cliente de que trata a assinatura
    private ClientEntity client;
    //Início da vigência da assinatura
    private LocalDate startDate;
    //Fim da vigência da assinatura
    private LocalDate endDate;
}