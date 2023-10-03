package br.com.xavecoding.regescweb.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String rg;
    private String email;
    private String curso;
    private Long saldo;
    private ArrayList <Transacao> transacoes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Instituicao instituicao;

    public Aluno() {  }

    public Aluno(String nome, Long saldo, Instituicao instituicao, String rg) {
        this.nome = nome;
        this.saldo = saldo;
        this.rg = rg;
        this.instituicao = instituicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getSalario() {
        return saldo;
    }

    public void getSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public void receberMoedas(Transacao trans, Long qtd){
        this.saldo += qtd;
        this.transacoes.add(trans);
    }

     /**
     * @return String return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    /**
     * @return ArrayList <Transacao> return the transacoes
     */
    public ArrayList <Transacao> getTransacoes() {
        return transacoes;
    }

    /**
     * @param transacoes the transacoes to set
     */
    public void setTransacoes(ArrayList <Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    /**
     * @return Instituicao return the instituicao
     */
    public Instituicao getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    

    @Override
    public String toString() {
        return "Aluno{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", saldo=" + saldo +
               ", instituicao=" + instituicao +
               '}';
    }

}
