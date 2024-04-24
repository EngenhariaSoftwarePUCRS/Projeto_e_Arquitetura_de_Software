package com.projarq.sistemavendasjpa.interfaceAdaptadora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarq.sistemavendasjpa.aplicacao.casosDeUso.CriaOrcamentoUC;
import com.projarq.sistemavendasjpa.aplicacao.casosDeUso.EfetivaOrcamentoUC;
import com.projarq.sistemavendasjpa.aplicacao.casosDeUso.ProdutosDisponiveisUC;
import com.projarq.sistemavendasjpa.aplicacao.dtos.ItemPedidoDTO;
import com.projarq.sistemavendasjpa.aplicacao.dtos.OrcamentoDTO;
import com.projarq.sistemavendasjpa.aplicacao.dtos.ProdutoDTO;
import com.projarq.sistemavendasjpa.dominio.modelos.ProdutoModel;
import com.projarq.sistemavendasjpa.dominio.persistencia.IProdutoRepositorio;

@RestController
public class Controller {
    private ProdutosDisponiveisUC produtosDisponiveis;
    private CriaOrcamentoUC criaOrcamento;
    private EfetivaOrcamentoUC efetivaOrcamento;

    @Autowired
    public Controller(ProdutosDisponiveisUC produtosDisponiveis,
                      CriaOrcamentoUC criaOrcamento,
                      EfetivaOrcamentoUC efetivaOrcamento){
        this.produtosDisponiveis = produtosDisponiveis;
        this.criaOrcamento = criaOrcamento;
        this.efetivaOrcamento = efetivaOrcamento;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage(){
        return("Bem vindo as lojas ACME");
    }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> produtosDisponiveis(){
        return produtosDisponiveis.run();
    }    

    @PostMapping("novoOrcamento")
    @CrossOrigin(origins = "*")
    public OrcamentoDTO novoOrcamento(@RequestBody List<ItemPedidoDTO> itens){
        return criaOrcamento.run(itens);
    }

    @GetMapping("efetivaOrcamento/{id}")
    @CrossOrigin(origins = "*")
    public OrcamentoDTO efetivaOrcamento(@PathVariable(value="id") long idOrcamento){
        return efetivaOrcamento.run(idOrcamento);
    }
}