package com.example.clinica.controller;

import com.example.clinica.model.Consulta;
import com.example.clinica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@Tag(name = "Consultas", description = "Operaciones relacionadas con las consultas médicas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    @Operation(summary = "Obtener todas las consultas", description = "Obtiene una lista de todas las consultas médicas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public List<Consulta> getAllConsultas() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener consulta por ID", description = "Obtiene una consulta específica por su ID")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public Consulta getConsultaById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear nueva consulta", description = "Registra una nueva consulta médica")
    @ApiResponse(responseCode = "201", description = "Consulta creada exitosamente")
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar consulta", description = "Actualiza una consulta médica existente")
    @ApiResponse(responseCode = "200", description = "Consulta actualizada exitosamente")
    public Consulta updateConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        consulta.setId(id);
        return consultaService.save(consulta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar consulta", description = "Elimina una consulta por su ID")
    @ApiResponse(responseCode = "204", description = "Consulta eliminada exitosamente")
    public void deleteConsulta(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
}
