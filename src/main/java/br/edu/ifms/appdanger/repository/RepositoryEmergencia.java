package br.edu.ifms.appdanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.appdanger.model.Emergencia;
@Repository
public interface RepositoryEmergencia extends JpaRepository<Emergencia, Integer>{

}
