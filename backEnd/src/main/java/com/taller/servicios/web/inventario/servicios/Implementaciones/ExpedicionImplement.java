package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Expedicion;
import com.taller.servicios.web.inventario.repositorios.ExpedicionRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.ExpedicionInterface;





@Service
public class ExpedicionImplement implements ExpedicionInterface {
    
    @Autowired
    private ExpedicionRepository repositorio;

    @Override
    public List<Expedicion> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Expedicion guardar(Expedicion expedicion){
        return repositorio.save(expedicion);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}
