package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.InformeStock;
import com.taller.servicios.web.inventario.repositorios.InformeStockRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.InformeStockInterface;



@Service
public class InformeStockImplement implements InformeStockInterface {
    
    @Autowired
    private InformeStockRepository repositorio;

    @Override
    public List<InformeStock> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeStock guardar(InformeStock informeStock){
        return repositorio.save(informeStock);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}
