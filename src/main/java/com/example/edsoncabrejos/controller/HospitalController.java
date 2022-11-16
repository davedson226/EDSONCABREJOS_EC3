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


import com.example.edsoncabrejos.model.Hospital;
import com.example.edsoncabrejos.service.HospitalService;


@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

	@Autowired
    private HospitalService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Hospital>> obtener() {
        return new ResponseEntity<List<Hospital>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hospital> buscar(@PathVariable Integer id) {
    	Hospital hospital = service.obtener(id);

        if (hospital != null) {
            return new ResponseEntity<Hospital>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Hospital h) {
        if (h != null) {
            service.guardar(h);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Hospital h) {
    	Hospital hospital = service.obtener(h.getIdHospital());

        if (hospital != null) {
            service.actualizar(h);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	Hospital h = service.obtener(id);
        if (h != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
