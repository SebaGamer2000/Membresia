package com.Membresias.Membresias.Membresias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Membresia")

public class Membresias {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idMembresia;

    @Column(nullable = false)
    private String tipoPlan;

    @Column(nullable = false)
    private String beneficio;

    @Column
    private int precio;
}
