package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Cita;
import com.example.clinica.repository.CitaRepository;
import com.example.clinica.service.CitaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {

    @InjectMocks
    private CitaService citaService;

    @Mock
    private CitaRepository citaRepository;

    @Test
    public void testFindAll() {
        Cita cita = new Cita();
        cita.setId(1L);
        cita.setFechaHora(new Date());
        // Puedes agregar más atributos si existen

        when(citaRepository.findAll()).thenReturn(List.of(cita));

        List<Cita> citas = citaService.findAll();

        assertNotNull(citas);
        assertEquals(1, citas.size());
        assertEquals(1, citas.get(0).getId());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Cita cita = new Cita();
        cita.setId(id);
        cita.setFechaHora(new Date());

        when(citaRepository.findById(id)).thenReturn(Optional.of(cita));

        Cita found = citaService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave() {
        Cita cita = new Cita();
        cita.setId(1L);
        cita.setFechaHora(new Date());

        when(citaRepository.save(cita)).thenReturn(cita);

        Cita saved = citaService.save(cita);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
    }
}
