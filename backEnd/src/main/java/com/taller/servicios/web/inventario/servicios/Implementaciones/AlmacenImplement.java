package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Almacen;
import com.taller.servicios.web.inventario.repositorios.AlmacenRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.AlmacenInterface;

@Service
public class AlmacenImplement implements AlmacenInterface {
    
    @Autowired
    private AlmacenRepository repositorio;

    @Override
    public List<Almacen> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Almacen guardar(Almacen almacen){
        return repositorio.save(almacen);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
    
}

