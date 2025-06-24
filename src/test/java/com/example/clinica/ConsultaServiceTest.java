package com.example.clinica;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.clinica.model.Consulta;
import com.example.clinica.repository.ConsultaRepository;
import com.example.clinica.service.ConsultaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class ConsultaServiceTest {

    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepository consultaRepository;

    @Test
    public void testFindAll() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        consulta.setFechaConsulta(new Date().toInstant()
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalDateTime());
        // Agrega más campos si tienes

        when(consultaRepository.findAll()).thenReturn(List.of(consulta));

        List<Consulta> consultas = consultaService.findAll();

        assertNotNull(consultas);
        assertEquals(1, consultas.size());
        assertEquals(1, consultas.get(0).getId());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setFechaConsulta(new Date().toInstant()
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalDateTime());

        when(consultaRepository.findById(id)).thenReturn(Optional.of(consulta));

        Consulta found = consultaService.findById(id);

        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        consulta.setFechaConsulta(new Date().toInstant()
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalDateTime());

        when(consultaRepository.save(consulta)).thenReturn(consulta);

        Consulta saved = consultaService.save(consulta);

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
    }
}
