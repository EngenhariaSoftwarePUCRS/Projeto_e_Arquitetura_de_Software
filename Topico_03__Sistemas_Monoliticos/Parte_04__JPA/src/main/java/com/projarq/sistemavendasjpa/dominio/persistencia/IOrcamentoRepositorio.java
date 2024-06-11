package com.projarq.sistemavendasjpa.dominio.persistencia;

import java.util.List;

import com.projarq.sistemavendasjpa.dominio.modelos.OrcamentoModel;

public interface IOrcamentoRepositorio {
    List<OrcamentoModel> todos();
    OrcamentoModel cadastra(OrcamentoModel orcamento);
    OrcamentoModel recuperaPorId(long id);
    void marcaComoEfetivado(long id); 
}
