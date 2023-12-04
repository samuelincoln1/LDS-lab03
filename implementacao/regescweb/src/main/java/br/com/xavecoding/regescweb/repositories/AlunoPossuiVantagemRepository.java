package br.com.xavecoding.regescweb.repositories;
import br.com.xavecoding.regescweb.models.AlunoPossuiVantagem;
import br.com.xavecoding.regescweb.models.Vantagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoPossuiVantagemRepository extends JpaRepository<AlunoPossuiVantagem, Long> {

}
