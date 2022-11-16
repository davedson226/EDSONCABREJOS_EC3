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

import com.example.edsoncabrejos.model.Cliente;
import com.example.edsoncabrejos.service.ClienteService;


@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {


	@Autowired
    private ClienteService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> obtener() {
        return new ResponseEntity<List<Cliente>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
    	Cliente cliente = service.obtener(id);

        if (cliente != null) {
            return new ResponseEntity<Cliente>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Cliente c) {
        if (c != null) {
            service.guardar(c);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Cliente c) {
    	Cliente cliente = service.obtener(c.getIdCliente());

        if (cliente != null) {
            service.actualizar(c);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	Cliente c = service.obtener(id);
        if (c != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
