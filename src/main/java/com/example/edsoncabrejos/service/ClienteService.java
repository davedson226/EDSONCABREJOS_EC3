package com.example.edsoncabrejos.service;

import java.util.List;

import com.example.edsoncabrejos.model.Cliente;

public interface ClienteService {

	void guardar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Integer id);
    List<Cliente> listar();
    Cliente obtener(Integer id);
}
