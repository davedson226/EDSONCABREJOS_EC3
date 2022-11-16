package com.example.edsoncabrejos.service;

import java.util.List;

import com.example.edsoncabrejos.model.UsuarioCliente;



public interface UsuarioClienteService {

	void guardar(UsuarioCliente usuariocliente);
    void actualizar(UsuarioCliente usuariocliente);
    void eliminar(Integer id);
    List<UsuarioCliente> listar();
    UsuarioCliente obtener(Integer id);
}
