package br.com.xavecoding.regescweb.repositories;

import br.com.xavecoding.regescweb.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query(value="SELECT * FROM aluno WHERE email = :email AND senha = :senha", nativeQuery = true)
    public Aluno Login(String email, String senha); 

    @Query(value="SELECT * FROM aluno WHERE nome = :nome", nativeQuery = true)
    public Aluno BuscaPorNome(String nome);
}
