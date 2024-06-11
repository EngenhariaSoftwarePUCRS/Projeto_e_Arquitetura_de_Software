package com.projarq.sistemavendasjpa.dominio.persistencia;

import java.util.List;

import com.projarq.sistemavendasjpa.dominio.modelos.ProdutoModel;

public interface IEstoqueRepositorio {
    List<ProdutoModel> todos();
    List<ProdutoModel> todosComEstoque();
    int quantidadeEmEstoque(long codigo);
    int baixaEstoque(long codProd, int qtdade);
}
