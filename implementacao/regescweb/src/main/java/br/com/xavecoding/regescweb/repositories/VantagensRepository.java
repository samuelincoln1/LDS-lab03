package br.com.xavecoding.regescweb.repositories;
import br.com.xavecoding.regescweb.models.Vantagem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VantagensRepository extends JpaRepository<Vantagem, Long> {
    @Query(value="SELECT * FROM vantagem WHERE id = :id", nativeQuery = true)
    public Vantagem ListarVantagemPorId(int id);

    @Query(value="INSERT INTO aluno_possui_vantagem (vantagem_id, aluno_id) VALUES(:idVantagem, :idAluno)", nativeQuery = true)
    public int ObterVantagem(int idAluno, int idVantagem);
}
