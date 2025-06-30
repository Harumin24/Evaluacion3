package com.example.clinica.controller;

import com.example.clinica.model.Especialidad;
import com.example.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
@Tag(name = "Especialidades", description = "Operaciones relacionadas con las especialidades médicas")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    @Operation(summary = "Obtener todas las especialidades", description = "Devuelve una lista con todas las especialidades médicas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        List<Especialidad> especialidades = especialidadService.findAll();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener especialidad por ID", description = "Devuelve una especialidad específica mediante su ID")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @ApiResponse(responseCode = "404", description = "Especialidad no encontrada")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Integer id) {
        Especialidad especialidad = especialidadService.findById(id != null ? id.longValue() : null);
        if (especialidad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(especialidad);
    }

    @PostMapping
    @Operation(summary = "Crear una especialidad", description = "Registra una nueva especialidad médica")
    @ApiResponse(responseCode = "201", description = "Especialidad creada exitosamente")
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad creada = especialidadService.save(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar especialidad", description = "Modifica los datos de una especialidad existente")
    @ApiResponse(responseCode = "200", description = "Especialidad actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Especialidad no encontrada")
    public ResponseEntity<Especialidad> updateEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        Especialidad existente = especialidadService.findById(id != null ? id.longValue() : null);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        especialidad.setId(id != null ? id.longValue() : null);
        Especialidad actualizada = especialidadService.save(especialidad);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar especialidad", description = "Elimina una especialidad según su ID")
    @ApiResponse(responseCode = "204", description = "Especialidad eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Especialidad no encontrada")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Integer id) {
        Especialidad existente = especialidadService.findById(id != null ? id.longValue() : null);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        especialidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
