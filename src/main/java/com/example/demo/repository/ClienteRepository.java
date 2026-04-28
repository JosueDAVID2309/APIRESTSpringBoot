package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbc;

    public ClienteRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Cliente> listar() {
        String sql = "SELECT * FROM clientes";

        return jdbc.query(sql, (rs, i) -> {
            Cliente c = new Cliente();
            c.setId(rs.getLong("id"));
            c.setNombre(rs.getString("nombre"));
            return c;
        });
    }

    public void guardar(Cliente c) {
        String sql = "INSERT INTO clientes(nombre) VALUES (?)";
        jdbc.update(sql, c.getNombre());
    }

    public Cliente obtener(Long id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, i) -> {
            Cliente c = new Cliente();
            c.setId(rs.getLong("id"));
            c.setNombre(rs.getString("nombre"));
            return c;
        });
    }

    public void eliminar(Long id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void editar(String nombre, Long id){
        String sql = "UPDATE clientes SET nombre = ? WHERE id = ?";
        jdbc.update(sql, nombre, id);
    }
}