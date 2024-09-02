package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.InformeVentas;
import com.taller.servicios.web.inventario.repositorios.InformeVentasRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.InformeVentasInterface;

@Service
public class InformeVentasImplement implements InformeVentasInterface {
    
    @Autowired
    private InformeVentasRepository repositorio;

    @Override
    public List<InformeVentas> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeVentas guardar(InformeVentas informeVentas){
        return repositorio.save(informeVentas);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}