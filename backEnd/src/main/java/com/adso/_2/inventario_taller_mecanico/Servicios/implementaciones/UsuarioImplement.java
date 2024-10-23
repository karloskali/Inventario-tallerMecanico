package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Usuario;
import com.adso._2.inventario_taller_mecanico.Repositorios.UsuarioRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.UsuarioInterface;

@Service
public class UsuarioImplement implements UsuarioInterface {
    
    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<Usuario> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Usuario> buscarPorId(Integer id){
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