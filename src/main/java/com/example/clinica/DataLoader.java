package com.example.clinica;

import com.example.clinica.model.Especialidad;
import com.example.clinica.model.Medico;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.EspecialidadRepository;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("test") // Solo se ejecuta si activas el perfil 'test'
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public void run(String... args) {
        Faker faker = new Faker();

        // Crear especialidades ficticias
        List<Especialidad> especialidades = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Especialidad esp = new Especialidad();
            esp.setNombre(faker.medical().diseaseName());
            especialidades.add(especialidadRepository.save(esp));
        }

        // Crear 10 pacientes ficticios
        for (int i = 0; i < 10; i++) {
            Paciente paciente = new Paciente();
            paciente.setNombre(faker.name().firstName());
            paciente.setApellido(faker.name().lastName());
            paciente.setEmail(faker.internet().emailAddress());
            pacienteRepository.save(paciente);
        }

        // Crear 5 médicos ficticios y asignar especialidades aleatorias
        for (int i = 0; i < 5; i++) {
            Medico medico = new Medico();
            medico.setNombre(faker.name().fullName());
            medico.setEmail(faker.internet().emailAddress());
            medico.setEspecialidad(faker.options().nextElement(especialidades)); // Aleatoria
            medicoRepository.save(medico);
        }

        System.out.println("✔ Datos de prueba insertados con éxito.");
    }
}
