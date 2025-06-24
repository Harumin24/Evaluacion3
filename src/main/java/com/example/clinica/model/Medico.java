package com.example.clinica.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;

    private String telefono;

    private String email;

    public void setEspecialidad(String diseaseName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEspecialidad'");
    }
}
