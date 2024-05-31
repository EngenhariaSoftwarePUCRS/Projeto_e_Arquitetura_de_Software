package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.domain.repository.IAppRepository;

@CrossOrigin(origins = "*")
@RestController
public class AppController {
    private IAppRepository appRepository;

    @Autowired
    public AppController(IAppRepository appRepository) {
        this.appRepository = appRepository;
    }

    /** Lista com todos os aplicativos cadastrados */
    @GetMapping("/servcad/aplicativos")
    public List<AppEntity> getApps() {
        return appRepository.getAll();
    }

    /** Atualizar o custo mensal do aplicativo */
    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public AppEntity updateCost(
        @PathVariable("idAplicativo") final Long appId,
        @RequestBody final float monthlyCost
    ) {
        return appRepository.updateMonthlyCost(appId, monthlyCost);
    }
}