package br.com.outflux.regesc.web.models;

public class Instituicao {
    private long id;
    private String nome;

    public Instituicao() {
        // Default no-argument constructor
    }

    public Instituicao(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

}
