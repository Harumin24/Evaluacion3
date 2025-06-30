package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Especialidad;
import com.example.clinica.repository.EspecialidadRepository;
import com.example.clinica.service.EspecialidadService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EspecialidadServiceTest {

    @InjectMocks
    private EspecialidadService especialidadService;

    @Mock
    private EspecialidadRepository especialidadRepository;

    @Test
    public void testFindAll() {
        Especialidad especialidad = new Especialidad();
        especialidad.setId(1L);
        especialidad.setNombre("Cardiología");

        when(especialidadRepository.findAll()).thenReturn(List.of(especialidad));

        List<Especialidad> especialidades = especialidadService.findAll();

        assertNotNull(especialidades);
        assertEquals(1, especialidades.size());
        assertEquals("Cardiología", especialidades.get(0).getNombre());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Especialidad especialidad = new Especialidad();
        especialidad.setId(id);
        especialidad.setNombre("Cardiología");

        when(especialidadRepository.findById(id)).thenReturn(Optional.of(especialidad));

        Especialidad found = especialidadService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals("Cardiología", found.getNombre());
    }

    @Test
    public void testFindByIdNotFound() {
        Long id = 99L;
        when(especialidadRepository.findById(id)).thenReturn(Optional.empty());

        Especialidad found = especialidadService.findById(id);

        assertNull(found);
    }

    @Test
    public void testSave() {
        Especialidad especialidad = new Especialidad();
        especialidad.setId(1L);
        especialidad.setNombre("Cardiología");

        when(especialidadRepository.save(especialidad)).thenReturn(especialidad);

        Especialidad saved = especialidadService.save(especialidad);

        assertNotNull(saved);
        assertEquals("Cardiología", saved.getNombre());
    }
}
