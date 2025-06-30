package com.example.clinica.service;

import com.example.clinica.model.Especialidad;
import com.example.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    public Especialidad findById(Long id) {
        Object result = especialidadRepository.findById(id);
        if (result instanceof java.util.Optional) {
            return ((java.util.Optional<Especialidad>) result).orElse(null);
        } else if (result instanceof Especialidad) {
            return (Especialidad) result;
        } else {
            return null;
        }
    }

    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public void deleteById(Integer id) {
        especialidadRepository.deleteById(id);
    }

    // Removed duplicate findById(Long id) method to resolve compilation error.
}
