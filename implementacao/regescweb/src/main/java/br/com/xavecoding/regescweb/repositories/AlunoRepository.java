package br.com.xavecoding.regescweb.repositories;

import br.com.xavecoding.regescweb.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
