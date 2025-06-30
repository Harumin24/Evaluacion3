package com.example.clinica;

import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataFaker implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final Faker faker = new Faker();

    public DataFaker(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void run(String... args) {
        if (pacienteRepository.count() == 0) {
            for (int i = 0; i < 20; i++) {
                Paciente paciente = new Paciente();
                paciente.setNombre(faker.name().firstName());
                paciente.setApellido(faker.name().lastName());
                paciente.setEmail(faker.internet().emailAddress());
                paciente.setTelefono(faker.phoneNumber().cellPhone());
                // Agrega más atributos aquí según tu entidad Paciente
                pacienteRepository.save(paciente);
            }
            System.out.println("Datos de prueba generados para Paciente.");
        }
    }
}