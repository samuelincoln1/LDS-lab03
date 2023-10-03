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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
    @Column(nullable = false)
    private String name;
    private Instituicao instituicao;
    private ArrayList<Transacao> transacoes = new ArrayList<>();
    private Double saldo = 0.0;


    public Professor(String cpf, String name, Instituicao instituicao) {
        this.cpf = cpf;
        this.name = name;
        this.instituicao = instituicao;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public Double getSaldo(){
        return this.saldo;
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

    public Instituicao getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }


    public Professor cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Professor name(String name) {
        setName(name);
        return this;
    }

    public Professor instituicao(Instituicao instituicao) {
        setInstituicao(instituicao);
        return this;
    }

    public Boolean enviarMoedas(Double qtd, Aluno aluno, String msg){
        if (this.saldo >= qtd){
            saldo -= qtd;
            Transacao trans = new Transacao(TipoTransacao.ENVIAR, msg, qtd, this.name, aluno.getName());
            this.transacoes.add(trans);
            trans.setTipo(TipoTransacao.RECEBER);
            aluno.receberMoedas(trans, qtd);
            return true;

        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, instituicao);
    }

    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", name='" + getName() + "'" +
            ", instituicao='" + getInstituicao() + "'" +
            "}";
    }

    public Professor() {
    }

    
}
