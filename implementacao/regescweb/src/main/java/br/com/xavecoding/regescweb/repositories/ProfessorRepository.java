package br.com.xavecoding.regescweb.repositories;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
  @Query(value="SELECT * FROM professor WHERE nome = :nome AND senha = :senha", nativeQuery = true)
    public Professor Login(String nome, String senha); 


       @Query(value="SELECT * FROM professor WHERE nome = :nome", nativeQuery = true)
    public Professor BuscaPorNome(String nome);

}