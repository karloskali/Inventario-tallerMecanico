package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Producto;
import com.adso._2.inventario_taller_mecanico.Repositorios.ProductoRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProductoInterface;


@Service
public class ProductoImplement implements ProductoInterface {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<Producto> listarTodos(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    @Override
    public Producto guardar(Producto producto){
        return repositorio.save(producto);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
        
}
