package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Proveedor;
import com.adso._2.inventario_taller_mecanico.Repositorios.ProveedorRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProveedorInterface;


@Service
public class ProveedorImplement implements ProveedorInterface {
    
    @Autowired
    private ProveedorRepository repositorio;

    @Override
    public List<Proveedor> listarTodos(){
        return repositorio.findAll();
            }
    

    @Override
    public Optional<Proveedor> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    @Override
    public Optional<Proveedor> findByNombre(String Nombre){
        return repositorio.findByNombre(Nombre);
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
