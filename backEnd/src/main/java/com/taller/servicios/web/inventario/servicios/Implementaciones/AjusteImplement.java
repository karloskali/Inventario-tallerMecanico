package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Ajuste;
import com.taller.servicios.web.inventario.repositorios.AjusteRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.AjusteInterface;


@Service
public class AjusteImplement implements AjusteInterface {
    
    @Autowired
    private AjusteRepository repositorio;

    @Override
    public List<Ajuste> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Ajuste guardar(Ajuste ajuste){
        return repositorio.save(ajuste);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
    
}

