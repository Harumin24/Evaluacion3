package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Cita;
import com.example.clinica.model.Paciente;
import com.example.clinica.model.Medico;
import com.example.clinica.repository.CitaRepository;
import com.example.clinica.service.CitaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {

    @InjectMocks
    private CitaService citaService;

    @Mock
    private CitaRepository citaRepository;

    private Cita buildCitaMock() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("Juan");

        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNombre("Dra. Ana");

        Cita cita = new Cita();
        cita.setId(1L);
        cita.setFechaHora(LocalDateTime.now());
        cita.setPaciente(paciente);
        cita.setMedico(medico);

        return cita;
    }

    @Test
    public void testFindAll() {
        Cita cita = buildCitaMock();

        when(citaRepository.findAll()).thenReturn(List.of(cita));

        List<Cita> citas = citaService.findAll();

        assertNotNull(citas);
        assertEquals(1, citas.size());
        assertEquals(1L, citas.get(0).getId());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Cita cita = buildCitaMock();

        when(citaRepository.findById(id)).thenReturn(Optional.of(cita));

        Cita found = citaService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals("Juan", found.getPaciente().getNombre());
    }

    @Test
    public void testSave() {
        Cita cita = buildCitaMock();

        when(citaRepository.save(cita)).thenReturn(cita);

        Cita saved = citaService.save(cita);

        assertNotNull(saved);
        assertEquals("Dra. Ana", saved.getMedico().getNombre());
    }
}
