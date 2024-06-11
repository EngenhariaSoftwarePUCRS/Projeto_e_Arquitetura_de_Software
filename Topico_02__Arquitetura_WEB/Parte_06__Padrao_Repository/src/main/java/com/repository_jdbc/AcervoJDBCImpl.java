package com.repository_jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public class AcervoJDBCImpl implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        String sql = "INSERT into livros (codigo, titulo, autor, ano) VALUES (?, ?, ?, ?)";
        int updated = this.jdbcTemplate.update(
            sql,
            livro.getId(),
            livro.getTitulo(),
            livro.getAutor(),
            livro.getAno()
        );
        return updated > 0;
    }

    @Override
    public List<Livro> getAll() {
        String sql = "SELECT * FROM livros";
        List<Livro> livros = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new Livro(
                rs.getLong("codigo"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano")
            );
        });
        return livros;
    }

    @Override
    public List<String> getAutores() {
        String sql = "SELECT autor FROM livros";
        List<String> autores = jdbcTemplate.queryForList(sql, String.class);
        return autores;
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        String sql = "SELECT * FROM livros WHERE titulo = ?";
        Livro livro = jdbcTemplate.queryForObject(sql, Livro.class, titulo);
        return livro;
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        String sql = "SELECT * FROM livros WHERE autor = ?";
        List<Livro> livros = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new Livro(
                rs.getLong("codigo"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getInt("ano")
            );
        }, autor);
        return livros;
    }

    @Override
    public List<String> getTitulos() {
        String sql = "SELECT titulo FROM livros";
        List<String> titulos = jdbcTemplate.queryForList(sql, String.class);
        return titulos;
    }

    @Override
    public boolean removeLivro(long codigo) {
        String sql = "DELETE FROM livros WHERE codigo = ?";
        int updated = this.jdbcTemplate.update(sql, codigo);
        return updated > 0;
    }
}
