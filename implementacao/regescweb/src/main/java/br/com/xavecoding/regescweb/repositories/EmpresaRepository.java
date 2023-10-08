package br.com.xavecoding.regescweb.repositories;

import br.com.xavecoding.regescweb.models.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    @Query(value="SELECT * FROM empresa WHERE nome = :nome AND senha = :senha", nativeQuery = true)
    public Empresa Login(String nome, String senha); 
}
