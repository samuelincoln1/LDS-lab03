package br.com.outflux.regesc.web.models;

import java.math.BigDecimal;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
    @Column(nullable = false)
    private String name;
    private String rg;
    private Instituicao instituicao;
    private Double saldo = 0.0;
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(String cpf, String name, String rg, Instituicao instituicao) {
        this.cpf = cpf;
        this.name = name;
        this.rg = rg;
        this.instituicao = instituicao;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Instituicao getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Aluno cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Aluno name(String name) {
        setName(name);
        return this;
    }

    public Aluno rg(String rg) {
        setRg(rg);
        return this;
    }

    public Aluno instituicao(Instituicao instituicao) {
        setInstituicao(instituicao);
        return this;
    }

    public Aluno saldo(Double saldo) {
        setSaldo(saldo);
        return this;
    }

    public void receberMoedas(Transacao trans, Double qtd){
        this.saldo += qtd;
        this.transacoes.add(trans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, rg, instituicao, saldo);
    }

    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", name='" + getName() + "'" +
            ", rg='" + getRg() + "'" +
            ", instituicao='" + getInstituicao() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }
    
    
}
