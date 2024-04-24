package com.projarq.sistemavendasjpa.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarq.sistemavendasjpa.aplicacao.dtos.OrcamentoDTO;
import com.projarq.sistemavendasjpa.dominio.modelos.OrcamentoModel;
import com.projarq.sistemavendasjpa.dominio.servicos.ServicoDeVendas;

@Component
public class EfetivaOrcamentoUC {
    private ServicoDeVendas servicoDeVendas;
    
    @Autowired
    public EfetivaOrcamentoUC(ServicoDeVendas servicoDeVendas){
        this.servicoDeVendas = servicoDeVendas;
    }

    public OrcamentoDTO run(long idOrcamento){
        OrcamentoModel orcamento =  servicoDeVendas.efetivaOrcamento(idOrcamento);
        return OrcamentoDTO.fromModel(orcamento);
    }
}