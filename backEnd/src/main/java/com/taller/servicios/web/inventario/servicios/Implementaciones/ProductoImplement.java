package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Producto;
import com.taller.servicios.web.inventario.repositorios.ProductoRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.ProductoInterface;

@Service
public class ProductoImplement implements ProductoInterface {
    
    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<Producto> listarTodos(){
        return repositorio.findAll();
            }
    
    /*@Override
    public Optional<List<Producto>> buscar (String texto){
        return repositorio.findByNombreLikeOrVencimiento("%"+texto+"%",texto);
    }*/

    @Override
    public Optional buscarPorId(Integer id){
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
