package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Usuario;

public interface UsuarioInterface {

    public List<Usuario> listarTodos();
    public Optional<Usuario> buscarPorId(Integer id);
    public Usuario guardar(Usuario usuario);
    public void eliminar(Integer id);
    
}