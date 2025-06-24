package com.example.clinica.controller;

import com.example.clinica.model.Medico;
import com.example.clinica.service.MedicoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Médicos", description = "Operaciones relacionadas con los médicos")
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico getMedicoById(@PathVariable Integer id) {
        return medicoService.findById(id != null ? id.longValue() : null);
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable Integer id, @RequestBody Medico medico) {
        medico.setId(id != null ? id.longValue() : null);
        return medicoService.save(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Integer id) {
        medicoService.deleteById(id != null ? id.longValue() : null);
    }
}
