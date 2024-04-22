package com.projarq.trabalho01_clean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.entity.AppEntity;
import com.projarq.trabalho01_clean.repository.IAppRepository;

import jakarta.websocket.server.PathParam;

@RestController
public class AppController {
    private IAppRepository appRepository;

    @Autowired
    public AppController() {
        
    }

    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AppEntity> getApps() {
        return appRepository.getAll();
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/:idAplicativo") // Atualizar o custo mensal do aplicativo
    @CrossOrigin(origins = "*")
    public AppEntity updateCost(
        @PathParam("idAplicativo") final Long appId,
        @RequestBody final float monthlyCost
    ) {
        return appRepository.updateMonthlyCost(appId, monthlyCost);
    }
}