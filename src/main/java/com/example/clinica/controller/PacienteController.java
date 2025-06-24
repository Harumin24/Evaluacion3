package com.example.clinica.controller;

import com.example.clinica.model.Paciente;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@Tag(name = "Pacientes", description = "Operaciones relacionadas con los pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    @Operation(summary = "Obtener todos los pacientes", description = "Obtiene una lista de todos los pacientes")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public List<Paciente> getAllPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener paciente por ID", description = "Obtiene un paciente específico por su ID")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo paciente", description = "Registra un nuevo paciente")
    @ApiResponse(responseCode = "201", description = "Paciente creado exitosamente")
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar paciente", description = "Actualiza un paciente existente")
    @ApiResponse(responseCode = "200", description = "Paciente actualizado exitosamente")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return pacienteService.save(paciente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar paciente", description = "Elimina un paciente por su ID")
    @ApiResponse(responseCode = "204", description = "Paciente eliminado exitosamente")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}
