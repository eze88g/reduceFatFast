package ar.com.reduceFatFast.repository;

import org.springframework.data.repository.CrudRepository;

import ar.com.reduceFatFast.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
