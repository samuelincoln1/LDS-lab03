package br.com.xavecoding.regescweb.models;


import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Long saldo;
    private String departamento;
    private ArrayList <Transacao> transacoes = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Instituicao instituicao;

    public Professor() {  }

    public Professor(String nome, Long saldo, Instituicao instituicao, String departamento) {
        this.nome = nome;
        this.departamento = departamento;
        this.saldo = saldo;
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

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Boolean enviarMoedas(Long qtd, Aluno aluno, String msg){
        if (this.saldo >= qtd){
            saldo -= qtd;
            Transacao trans = new Transacao(TipoTransacao.ENVIAR, msg, qtd, this.nome, aluno.getNome());
            this.transacoes.add(trans);
            trans.setTipo(TipoTransacao.RECEBER);
            aluno.receberMoedas(trans, qtd);
            return true;

        }
        return false;
    }

    @Override
    public String toString() {
        return "Professor{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", saldo=" + saldo +
               ", Instituicao=" + instituicao +
               '}';
    }
}
