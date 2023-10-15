package br.com.xavecoding.regescweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="aluno_possui_vantagem")
@Entity(name="aluno_possui_vantagem")
public class AlunoPossuiVantagem {
    @GeneratedValue
    @Id
    public int id;
    public int aluno_id;
    public int vantagem_id;
    
    public AlunoPossuiVantagem(int aluno_id, int vantagem_id) {
        this.aluno_id = aluno_id;
        this.vantagem_id = vantagem_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getaluno_id() {
        return aluno_id;
    }
    public void setaluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }
    public int getvantagem_id() {
        return vantagem_id;
    }
    public void setvantagem_id(int vantagem_id) {
        this.vantagem_id = vantagem_id;
    }
}
