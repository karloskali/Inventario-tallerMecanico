package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Proveedor;
import com.taller.servicios.web.inventario.repositorios.ProveedorRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.ProveedorInterface;


@Service
public class ProveedorImplement implements ProveedorInterface {
    
    @Autowired
    private ProveedorRepository repositorio;

    @Override
    public List<Proveedor> listarTodos(){
        return repositorio.findAll();
            }
    

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Proveedor guardar(Proveedor proveedor){
        return repositorio.save(proveedor);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

}