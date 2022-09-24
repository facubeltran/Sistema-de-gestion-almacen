package ar.org.centro8.curso.java.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.repositories.ClienteRepository;

@Service
public class ClienteDataService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void remove(Integer id){
        clienteRepository.delete(clienteRepository.findById(id).get());
    }

    public void update(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente getById(Integer id){
        return clienteRepository.findById(id).orElse(new Cliente());
    }

    public List<Cliente> getAll(){
        return (List<Cliente>)clienteRepository.findAll();
    }

    public List<Cliente> getLikeApellido(String apellido){
        return (List<Cliente>)clienteRepository.findByApellidoContainingIgnoreCase(apellido);
    }

    public List<Cliente> getLikeCuit(String cuit){
        return (List<Cliente>)clienteRepository.findByCuitContaining(cuit);
    }

    public Cliente getByCuit(String cuit){
        return clienteRepository.findByCuit(cuit).get(0);
    }
}
