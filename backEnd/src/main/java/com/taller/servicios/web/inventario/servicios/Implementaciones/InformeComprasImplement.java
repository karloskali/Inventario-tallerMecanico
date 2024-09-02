package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.InformeCompras;
import com.taller.servicios.web.inventario.repositorios.InformeComprasRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.InformeComprasInterface;



@Service
public class InformeComprasImplement implements InformeComprasInterface {
    
    @Autowired
    private InformeComprasRepository repositorio;

    @Override
    public List<InformeCompras> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeCompras guardar(InformeCompras informeCompras){
        return repositorio.save(informeCompras);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}
