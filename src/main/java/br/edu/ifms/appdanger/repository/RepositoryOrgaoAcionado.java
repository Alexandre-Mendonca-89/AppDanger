package br.edu.ifms.appdanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.appdanger.model.OrgaoAcionado;
@Repository
public interface RepositoryOrgaoAcionado extends JpaRepository<OrgaoAcionado, Integer>{

}
