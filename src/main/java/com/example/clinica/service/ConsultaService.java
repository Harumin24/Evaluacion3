package com.example.clinica.service;

import com.example.clinica.model.Consulta;
import com.example.clinica.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }
}
