package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.DTO.ColaboradorDTO;
import com.adso._2.inventario_taller_mecanico.Entidades.Colaborador;

public interface  ColaboradorInterface {

    public List<Colaborador> listarTodos();
    public Optional<Colaborador> buscarPorId(Integer id);
    public Colaborador guardar(Colaborador colaborador);
    public void eliminar(Integer id);

    public Colaborador crearColaborador(ColaboradorDTO colaboradorDTO);
    public Optional<Colaborador> login(String user, String password);
    
}
