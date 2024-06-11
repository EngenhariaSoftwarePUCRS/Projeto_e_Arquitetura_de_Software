package com.projarq.sistemavendasjpa.dominio.persistencia;

import java.util.List;

import com.projarq.sistemavendasjpa.dominio.modelos.ProdutoModel;

public interface IProdutoRepositorio {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
