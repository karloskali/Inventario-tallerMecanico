package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Cliente;

public interface ClienteInterface {

    public List<Cliente> listarTodos();
    public Optional<Cliente> buscarPorId(Integer id);
    public Cliente guardar(Cliente cliente);
    public void eliminar(Integer id);
    
}
