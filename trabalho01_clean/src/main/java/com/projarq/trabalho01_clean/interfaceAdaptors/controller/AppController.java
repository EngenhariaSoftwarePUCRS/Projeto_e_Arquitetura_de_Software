package com.projarq.trabalho01_clean.interfaceAdaptors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabalho01_clean.domain.entity.AppEntity;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.App.CreateAppDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.DTOs.App.EditAppDTO;
import com.projarq.trabalho01_clean.interfaceAdaptors.useCases.IAppUseCases;

@CrossOrigin(origins = "*")
@RestController
public class AppController {
    private IAppUseCases appService;

    @Autowired
    public AppController(IAppUseCases appService) {
        this.appService = appService;
    }

    /** Cadastrar na base de aplicativos */
    @PostMapping("/servcad/aplicativos")
    public AppEntity addApp(@RequestBody final CreateAppDTO app) {
        String appName = app.getName();
        float appMonthlyCost = app.getMonthlyCost();
        return appService.create(appName, appMonthlyCost);
    }

    /** Editar a base de aplicativos */
    @PutMapping("/servcad/aplicativos/{idAplicativo}")
    public AppEntity editApp(
        @PathVariable("idAplicativo") final Long appId,
        @RequestBody final EditAppDTO app
    ) {
        return appService.edit(appId, app);
    }

    /** Lista com todos os aplicativos cadastrados */
    @GetMapping("/servcad/aplicativos")
    public List<AppEntity> getApps() {
        return appService.getAll();
    }

    /** Atualizar o custo mensal do aplicativo */
    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public AppEntity updateCost(
        @PathVariable("idAplicativo") final Long appId,
        @RequestBody final float monthlyCost
    ) {
        return appService.updateMonthlyCost(appId, monthlyCost);
    }
}
