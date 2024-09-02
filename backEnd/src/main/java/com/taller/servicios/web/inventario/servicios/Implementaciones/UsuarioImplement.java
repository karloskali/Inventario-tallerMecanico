package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Usuario;
import com.taller.servicios.web.inventario.repositorios.UsuarioRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.UsuarioInterface;



@Service
public class UsuarioImplement implements UsuarioInterface {
    
    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<Usuario> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Usuario guardar(Usuario usuario){
        return repositorio.save(usuario);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}