package com.example.clinica.service;

import com.example.clinica.model.Cita;
import com.example.clinica.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Cita findById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
}
