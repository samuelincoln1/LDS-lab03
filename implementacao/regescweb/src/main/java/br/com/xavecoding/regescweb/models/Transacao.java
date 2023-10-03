package br.com.xavecoding.regescweb.models;


import java.util.Objects;

public class Transacao {
    private TipoTransacao tipo;
    private String mensagem;
    private Long valor;
    private String prof;
    private String aluno;


    public Transacao(TipoTransacao tipo, String mensagem, Long valor, String prof, String aluno) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.valor = valor;
        this.prof = prof;
        this.aluno = aluno;
    }


    public Transacao() {
    }

    public TipoTransacao getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getValor() {
        return this.valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getProf() {
        return this.prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getAluno() {
        return this.aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Transacao tipo(TipoTransacao tipo) {
        setTipo(tipo);
        return this;
    }

    public Transacao mensagem(String mensagem) {
        setMensagem(mensagem);
        return this;
    }

    public Transacao valor(Long valor) {
        setValor(valor);
        return this;
    }

    public Transacao prof(String prof) {
        setProf(prof);
        return this;
    }

    public Transacao aluno(String aluno) {
        setAluno(aluno);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, mensagem, valor, prof, aluno);
    }

    @Override
    public String toString() {
        if (this.tipo == TipoTransacao.ENVIAR){
           return "{" +
            " tipo='" + getTipo() + "'" +
            ", mensagem='" + getMensagem() + "'" +
            ", valor='" + getValor() + "'" +
            ", de prof='" + getProf() + "'" +
            ", para aluno='" + getAluno() + "'" +
            "}"; 
        }
        return "{" +
            " tipo='" + getTipo() + "'" +
            ", mensagem='" + getMensagem() + "'" +
            ", valor='" + getValor() + "'" +
            ", de prof='" + getProf() + "'" +
            ", para aluno='" + getAluno() + "'" +
            "}";
    }
    
}
