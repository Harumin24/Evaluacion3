package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Medico;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.service.MedicoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {

    @InjectMocks
    private MedicoService medicoService;

    @Mock
    private MedicoRepository medicoRepository;

    @Test
    public void testFindAll() {
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Dr. Juan Pérez");
        medico.setEspecialidad("Cardiología");
        medico.setEmail("juan@example.com");
        when(medicoRepository.findAll()).thenReturn(List.of(medico));

        List<Medico> medicos = medicoService.findAll();

        assertNotNull(medicos);
        assertEquals(1, medicos.size());
        assertEquals("Dr. Juan Pérez", medicos.get(0).getNombre());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Dr. Juan Pérez");
        medico.setEspecialidad("Cardiología");
        medico.setEmail("juan@example.com");
        when(medicoRepository.findById(id)).thenReturn(Optional.of(medico));

        Medico found = medicoService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals("Cardiología", found.getEspecialidad());
    }

    @Test
    public void testSave() {
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Dr. Juan Pérez");
        medico.setEspecialidad("Cardiología");
        medico.setEmail("juan@example.com");
        when(medicoRepository.save(medico)).thenReturn(medico);

        Medico saved = medicoService.save(medico);

        assertNotNull(saved);
        assertEquals("Dr. Juan Pérez", saved.getNombre());
    }
}
