package com.example.edsoncabrejos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edsoncabrejos.model.UsuarioCliente;
import com.example.edsoncabrejos.repository.UsuarioClienteRepository;
@Service
public class UsuarioClienteServiceImp implements UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public void guardar(UsuarioCliente usuariocliente) {
		// TODO Auto-generated method stub
		repository.save(usuariocliente);

	}

	@Override
	public void actualizar(UsuarioCliente usuariocliente) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(usuariocliente);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioCliente> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public UsuarioCliente obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
