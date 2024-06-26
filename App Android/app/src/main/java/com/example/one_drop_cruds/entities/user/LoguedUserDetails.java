package com.example.one_drop_cruds.entities.user;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

public class LoguedUserDetails {
    @SerializedName("token")
    String token;
    @SerializedName("id")
    Integer id;
    @SerializedName("username")
    String username;
    @SerializedName("dni")
    String dni;
    @SerializedName("email")
    String email;
    @SerializedName("role")
    Role role;
    @SerializedName("nombre")
    String nombre;
    @SerializedName("apellido")
    String apellido;
    @SerializedName("telefono")
    String telefono;
    @SerializedName("nacimiento")
    List<Integer> nacimiento; // Cambiado a List<LocalDate>
    @SerializedName("sexo")
    String sexo;

    public LoguedUserDetails() {
    }

    public LoguedUserDetails(String token, Integer id, String username, String dni, String email , Role role, String nombre, String apellido, String telefono, List<Integer> nacimiento, String sexo) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.dni = dni;
        this.email = email;
        this.role = role;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public List<Integer> getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(List<Integer> nacimiento) {
        this.nacimiento = nacimiento;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "LoguedUserDetails{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
