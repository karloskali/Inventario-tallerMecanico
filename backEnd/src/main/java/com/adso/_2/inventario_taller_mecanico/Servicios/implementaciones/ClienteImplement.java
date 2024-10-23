package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Cliente;
import com.adso._2.inventario_taller_mecanico.Repositorios.ClienteRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ClienteInterface;

@Service
public class ClienteImplement implements ClienteInterface {
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Cliente> buscarPorId(Integer id){
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
