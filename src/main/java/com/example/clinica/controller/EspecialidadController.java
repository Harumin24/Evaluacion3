package com.example.clinica.controller;

import com.example.clinica.model.Especialidad;
import com.example.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@Tag(name = "Especialidades", description = "Operaciones relacionadas con las especialidades médicas")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    @Operation(summary = "Obtener todas las especialidades", description = "Devuelve una lista con todas las especialidades médicas")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener especialidad por ID", description = "Devuelve una especialidad específica mediante su ID")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    public Especialidad getEspecialidadById(@PathVariable Integer id) {
        return especialidadService.findById(id != null ? id.longValue() : null);
    }

    @PostMapping
    @Operation(summary = "Crear una especialidad", description = "Registra una nueva especialidad médica")
    @ApiResponse(responseCode = "201", description = "Especialidad creada exitosamente")
    public Especialidad createEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadService.save(especialidad);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar especialidad", description = "Modifica los datos de una especialidad existente")
    @ApiResponse(responseCode = "200", description = "Especialidad actualizada exitosamente")
    public Especialidad updateEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        especialidad.setId(id != null ? id.longValue() : null);
        return especialidadService.save(especialidad);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar especialidad", description = "Elimina una especialidad según su ID")
    @ApiResponse(responseCode = "204", description = "Especialidad eliminada exitosamente")
    public void deleteEspecialidad(@PathVariable Integer id) {
        especialidadService.deleteById(id);
    }
}
