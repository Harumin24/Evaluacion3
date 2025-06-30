package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import com.example.clinica.service.PacienteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @Test
    public void testFindAll() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Ana");
        paciente.setApellido("González");
        paciente.setEmail("ana.gonzalez@example.com");

        when(pacienteRepository.findAll()).thenReturn(List.of(paciente));

        List<Paciente> pacientes = pacienteService.findAll();

        assertNotNull(pacientes);
        assertEquals(1, pacientes.size());
        assertEquals("Ana", pacientes.get(0).getNombre());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente.setNombre("Ana");
        paciente.setApellido("González");
        paciente.setEmail("ana.gonzalez@example.com");

        when(pacienteRepository.findById(id)).thenReturn(Optional.of(paciente));

        Paciente found = pacienteService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals("Ana", found.getNombre());
    }

    @Test
    public void testSave() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Ana");
        paciente.setApellido("González");
        paciente.setEmail("ana.gonzalez@example.com");

        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente saved = pacienteService.save(paciente);

        assertNotNull(saved);
        assertEquals("Ana", saved.getNombre());
    }
}
