package com.Membresias.Membresias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembresiaResponseDTO {
    private Long idMembresia;
    private String tipoPlan;
    private String beneficio;
    private Integer precio;
}
