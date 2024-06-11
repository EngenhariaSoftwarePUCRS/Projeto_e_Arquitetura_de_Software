package com.repository_jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class AcervoMemoriaImpl implements IAcervoRepository {
    private List<Livro> livros;

    public AcervoMemoriaImpl() {
        livros = List.of(
            new Livro(10, "Introdução ao Java", "Huguinho Pato", 2022),
            new Livro(20, "Introdução ao Spring-Boot", "Zezinho Pato", 2020),
            new Livro(15, "Principios SOLID", "Luizinho Pato", 2023),
            new Livro(17, "Padroes de Projeto", "Lala Pato", 2019)
        );
    }

    @Override
    public List<Livro> getAll() {
        return livros;
    }

    @Override
    public List<String> getTitulos() {
        return getAll()
                .stream()
                .map(livro -> livro.getTitulo())
                .toList();
    }

    @Override
    public List<String> getAutores() {
        return getAll()
                .stream()
                .map(livro -> livro.getAutor())
                .toList();
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return getAll()
                .stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return getAll()
                .stream()
                .filter(livro -> livro.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        livros.add(livro);
        return true;
    }

    @Override
    public boolean removeLivro(long codigo) {
        List<Livro> tmp = livros.stream()
                .filter(livro -> livro.getId() == codigo)
                .toList();
        return tmp.removeAll(tmp);
    }
}
