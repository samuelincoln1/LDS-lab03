package br.com.xavecoding.regescweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="professor")
@Entity(name="professor")

public class Professor {
    @Id 
    private int id;
    private String nome;
    private String instituicao;
    private String curso;
    private String senha;
    private String email;
    public int saldo;


    public Professor() {
    }

    public Professor(String nome, String instituicao, String curso) {
        this.nome = nome;
        this.instituicao = instituicao;
        this.curso = curso;
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

    public String getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail(){
        return this.email;
    }

    public int getSaldo() {
        return this.saldo;
    }

    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Professor id(int id) {
        setId(id);
        return this;
    }

    public Professor nome(String nome) {
        setNome(nome);
        return this;
    }

    public Professor instituicao(String instituicao) {
        setInstituicao(instituicao);
        return this;
    }

    public Professor curso(String curso) {
        setCurso(curso);
        return this;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", instituicao='" + getInstituicao() + "'" +
            ", curso='" + getCurso() + "'" +
            "}";
    }
    


}