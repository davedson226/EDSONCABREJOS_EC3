package com.example.edsoncabrejos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.edsoncabrejos.model.UsuarioCliente;

import com.example.edsoncabrejos.service.UsuarioClienteService;
@RestController
@RequestMapping("/api/v1/usuarioCliente")
public class UsuarioClienteController {

	@Autowired
    private UsuarioClienteService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioCliente>> obtener() {
        return new ResponseEntity<List<UsuarioCliente>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioCliente> buscar(@PathVariable Integer id) {
    	UsuarioCliente usuarioCliente = service.obtener(id);

        if (usuarioCliente != null) {
            return new ResponseEntity<UsuarioCliente>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente u) {
        if (u != null) {
            service.guardar(u);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody UsuarioCliente u) {
    	UsuarioCliente usuarioCliente = service.obtener(u.getIdUsuario());

        if (usuarioCliente != null) {
            service.actualizar(u);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	UsuarioCliente u = service.obtener(id);
        if (u != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
