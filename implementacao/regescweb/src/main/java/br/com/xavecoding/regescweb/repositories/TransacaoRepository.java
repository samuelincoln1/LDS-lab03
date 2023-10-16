package br.com.xavecoding.regescweb.repositories;

import br.com.xavecoding.regescweb.models.Aluno;
import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.Transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByProfessor(Professor professor);

    List<Transacao> findByAluno(Aluno aluno);
}

