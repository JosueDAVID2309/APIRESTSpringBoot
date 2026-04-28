package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.listar();
    }

    public void guardar(Cliente c) {
        repo.guardar(c);
    }

    public Cliente obtener(Long id) {
        return repo.obtener(id);
    }

    public void eliminar(Long id) {
        repo.eliminar(id);
    }

    public void editar(String nombre, Long id){
        repo.editar(nombre, id);
    }
}
