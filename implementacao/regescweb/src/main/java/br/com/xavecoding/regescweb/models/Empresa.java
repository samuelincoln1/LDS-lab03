package br.com.xavecoding.regescweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="empresa")
@Entity(name="empresa")

public class Empresa {
    @Id 
    private int id;
    private String nome;
    private String senha;


    public Empresa() {
    }

    public Empresa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Empresa id(int id) {
        setId(id);
        return this;
    }

    public Empresa nome(String nome) {
        setNome(nome);
        return this;
    }

    public Empresa senha(String senha) {
        setSenha(senha);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", senha='" + getSenha() + "'" +
            "}";
    }
    
    
}
