package com.pisis.oneDrop.auth.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {
    @NotNull(message = "Username no puede ser nulo")
    @Size(min=2, max=30, message = "Username debe tener entre 2 y 30 caracteres")
    String username;

    @NotNull(message = "Password no puede ser nulo")
    @Size(min=8, max=30, message = "Password debe tener entre 8 y 30 caracteres")
    String password1;

    @NotNull(message = "Password no puede ser nulo")
    @Size(min=8, max=30, message = "Password debe tener entre 8 y 30 caracteres")
    String password2;

    @NotNull(message = "Nombre no puede ser nulo")
    @Size(min=2, max=30, message = "Nombre debe tener entre 2 y 30 caracteres")
    String nombre;

    @NotNull(message = "Apellido no puede ser nulo")
    @Size(min=2, max=30, message = "Apellido debe tener entre 2 y 30 caracteres")
    String apellido;

    @NotNull(message = "Dni no puede ser nulo")
    @Size(min=8, max=10, message = "Dni debe tener entre 8 Y 10 caracteres")
    String dni;

    @NotNull(message = "Telefono no puede ser nulo")
    @Size(min=9, max=14, message = "Telefono debe tener entre 9 y 14 caracteres")
    String telefono;

    @NotNull(message = "Email no puede ser nulo")
    @Email(message = "Email con formato invalido")
    String email;

    @NotNull(message = "Fecha de nacimiento no puede ser nula")
    LocalDate nacimiento;

    @NotNull(message = "Sexo no puede ser nulo")
    String sexo;
}
