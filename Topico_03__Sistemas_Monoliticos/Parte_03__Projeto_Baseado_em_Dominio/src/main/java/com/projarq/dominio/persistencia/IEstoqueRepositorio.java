package com.projarq.dominio.persistencia;

import java.util.List;

import com.projarq.dominio.modelos.ProdutoModel;

public interface IEstoqueRepositorio {
    List<ProdutoModel> todos();
    List<ProdutoModel> todosComEstoque();
    int quantidadeEmEstoque(long codigo);
    void baixaEstoque(long codProd, int qtdade);
}
