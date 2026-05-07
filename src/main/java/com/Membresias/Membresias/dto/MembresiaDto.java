package com.Membresias.Membresias.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembresiaDto {
    @NotBlank(message = "El tipo de plan no puede estar vacio")
    private String tipo_Plan;

    @NotBlank(message = "El beneficio no puede estar vacio")
    private String beneficio;

    @NotNull(message = "El precio no puede estar vacio")
    @Positive(message = "El precio tiene que ser mayor a 0")
    private int precio;
}
