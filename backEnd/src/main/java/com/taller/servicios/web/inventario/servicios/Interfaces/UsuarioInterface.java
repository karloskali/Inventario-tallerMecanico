package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Usuario;

public interface UsuarioInterface {

    public List<Usuario> listarTodos();
    public Optional<Usuario> buscarPorId(Integer id);
    public Usuario guardar(Usuario usuario);
    public void eliminar(Integer id);
    
}
