package com.example.clinica.controller;

import com.example.clinica.model.Medico;
import com.example.clinica.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@Tag(name = "Médicos", description = "Operaciones relacionadas con los médicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    @Operation(summary = "Obtener todos los médicos", description = "Obtiene una lista de todos los médicos")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener médico por ID", description = "Obtiene un médico específico por su ID")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public Medico getMedicoById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo médico", description = "Registra un nuevo médico con su especialidad")
    @ApiResponse(responseCode = "201", description = "Médico creado exitosamente")
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar médico", description = "Actualiza un médico existente")
    @ApiResponse(responseCode = "200", description = "Médico actualizado exitosamente")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
        medico.setId(id);
        return medicoService.save(medico);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar médico", description = "Elimina un médico por su ID")
    @ApiResponse(responseCode = "204", description = "Médico eliminado exitosamente")
    public void deleteMedico(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
