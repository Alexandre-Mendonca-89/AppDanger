package br.edu.ifms.appdanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.appdanger.model.Instituicao;
@Repository
public interface RepositoryInstituicao extends JpaRepository<Instituicao, Integer>{

}
