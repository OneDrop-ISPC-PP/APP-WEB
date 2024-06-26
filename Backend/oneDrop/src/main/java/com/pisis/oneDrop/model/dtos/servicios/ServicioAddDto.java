package com.pisis.oneDrop.model.dtos.servicios;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioAddDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "Descripcion no puede ser nula")
    private String descripcion;

    @NotNull(message = "Precio no puede ser nulo")
    @PositiveOrZero(message = "El precio debe ser mayor a 0")
    private Integer precio;

    private String comentarios;
}
