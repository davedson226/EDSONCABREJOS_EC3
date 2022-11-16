package com.example.edsoncabrejos.service;

import java.util.List;


import com.example.edsoncabrejos.model.Hospital;

public interface HospitalService {

	void guardar(Hospital hospital);
    void actualizar(Hospital hospital);
    void eliminar(Integer id);
    List<Hospital> listar();
    Hospital obtener(Integer id);
}
