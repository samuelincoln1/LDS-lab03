package br.com.xavecoding.regescweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="aluno")
@Entity(name="aluno")

public class Aluno {
    @Id 
    public int id;
    public String nome;
    public String email;
    public String rg;
    public String endereco;
    public String instituicao;
    public String curso;
    public String senha;
    public int saldo;


    public Aluno() {
    }

    public Aluno(String nome, String email, String rg, String endereco, String instituicao, String curso) {

        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.endereco = endereco;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Aluno id(int id) {
        setId(id);
        return this;
    }

    public Aluno nome(String nome) {
        setNome(nome);
        return this;
    }

    public Aluno email(String email) {
        setEmail(email);
        return this;
    }

    public Aluno rg(String rg) {
        setRg(rg);
        return this;
    }

    public Aluno endereco(String endereco) {
        setEndereco(endereco);
        return this;
    }

    public Aluno instituicao(String instituicao) {
        setInstituicao(instituicao);
        return this;
    }

    public Aluno curso(String curso) {
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
            ", email='" + getEmail() + "'" +
            ", rg='" + getRg() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", instituicao='" + getInstituicao() + "'" +
            ", curso='" + getCurso() + "'" +
            "}";
    }
    


}