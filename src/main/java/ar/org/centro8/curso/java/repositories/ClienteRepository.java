package ar.org.centro8.curso.java.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.curso.java.entities.Cliente;

@Repository
public interface ClienteRepository  extends CrudRepository<Cliente, Integer> {
    public abstract List<Cliente>findByApellidoContainingIgnoreCase(String apellido);
    public abstract List<Cliente>findByCuit(String cuit);
    public abstract List<Cliente>findByCuitContaining(String cuit);
}
