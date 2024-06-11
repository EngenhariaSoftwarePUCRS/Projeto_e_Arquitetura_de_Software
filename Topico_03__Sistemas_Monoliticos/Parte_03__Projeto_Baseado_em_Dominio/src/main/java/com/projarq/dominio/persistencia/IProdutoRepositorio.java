package com.projarq.dominio.persistencia;

import java.util.List;

import com.projarq.dominio.modelos.ProdutoModel;

public interface IProdutoRepositorio {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
