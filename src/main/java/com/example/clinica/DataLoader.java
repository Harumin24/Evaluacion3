package com.example.clinica;

import com.example.clinica.model.Medico;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test") // Solo se ejecuta si activas el perfil 'test'
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void run(String... args) {
        Faker faker = new Faker();

        // Crear 10 pacientes ficticios
        for (int i = 0; i < 10; i++) {
            Paciente paciente = new Paciente();
            paciente.setNombre(faker.name().firstName());
            paciente.setApellido(faker.name().lastName());
            paciente.setEmail(faker.internet().emailAddress());
            pacienteRepository.save(paciente);
        }

        // Crear 5 médicos ficticios
        for (int i = 0; i < 5; i++) {
            Medico medico = new Medico();
            medico.setNombre(faker.name().fullName());
            medico.setEspecialidad(faker.medical().diseaseName());
            medico.setEmail(faker.internet().emailAddress());
            medicoRepository.save(medico);
        }

        System.out.println("✔ Datos de prueba insertados con éxito.");
    }
}
