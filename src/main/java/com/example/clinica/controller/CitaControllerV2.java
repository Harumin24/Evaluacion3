package com.example.clinica.controller;

import com.example.clinica.model.Cita;
import com.example.clinica.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/v2/citas")
@Tag(name = "Citas", description = "Operaciones relacionadas con las citas médicas")
public class CitaControllerV2 {

    @Autowired
    private CitaService citaService;

    @GetMapping
    @Operation(summary = "Obtener todas las citas", description = "Obtiene una lista de todas las citas agendadas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public List<Cita> getAllCitas() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cita por ID", description = "Obtiene los datos de una cita específica")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public Cita getCitaById(@PathVariable Long id) {
        return citaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Agendar una nueva cita", description = "Registra una nueva cita médica")
    @ApiResponse(responseCode = "201", description = "Cita creada exitosamente")
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.save(cita);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una cita", description = "Modifica los datos de una cita existente")
    @ApiResponse(responseCode = "200", description = "Cita actualizada exitosamente")
    public Cita updateCita(@PathVariable Long id, @RequestBody Cita cita) {
        cita.setId(id);
        return citaService.save(cita);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una cita", description = "Elimina una cita por su ID")
    @ApiResponse(responseCode = "204", description = "Cita eliminada exitosamente")
    public void deleteCita(@PathVariable Long id) {
        citaService.deleteById(id);
    }
}
