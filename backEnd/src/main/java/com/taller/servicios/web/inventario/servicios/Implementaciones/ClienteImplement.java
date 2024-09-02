package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Cliente;
import com.taller.servicios.web.inventario.repositorios.ClienteRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.ClienteInterface;

@Service
public class ClienteImplement implements ClienteInterface {
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Cliente guardar(Cliente cliente){
        return repositorio.save(cliente);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}

