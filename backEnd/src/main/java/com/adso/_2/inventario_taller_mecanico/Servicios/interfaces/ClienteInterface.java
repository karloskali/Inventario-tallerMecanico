package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Cliente;

public interface ClienteInterface {

    public List<Cliente> listarTodos();
    public Optional<Cliente> buscarPorId(Integer id);
    public Cliente guardar(Cliente cliente);
    public void eliminar(Integer id);
    
}
