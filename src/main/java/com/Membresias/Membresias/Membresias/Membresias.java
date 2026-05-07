package com.Membresias.Membresias.Membresias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Membrecia")

public class Membresias {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String tipo_Plan;

    @Column(nullable = false)
    private String beneficio;

    @Column
    private int precio;
}
