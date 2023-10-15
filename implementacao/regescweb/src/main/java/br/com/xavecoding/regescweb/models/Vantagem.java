package br.com.xavecoding.regescweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="vantagem")
@Entity(name="vantagem")
public class Vantagem {
    @GeneratedValue
    @Id
    public int id;
    public String nome;
    public String descricao;
    public String foto;
    public int custo;
    public int empresaId;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public int getCusto() {
        return custo;
    }
    public void setCusto(int custo) {
        this.custo = custo;
    }
    public int getEmpresaId() {
        return empresaId;
    }
    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }
}
