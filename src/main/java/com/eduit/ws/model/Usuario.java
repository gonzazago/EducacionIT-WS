package com.eduit.ws.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {

    @JsonProperty("user_name")
    private String nombre;
    @JsonProperty("user_password")
    private String contrasenia;

    @JsonCreator
    public Usuario( @JsonProperty("user_name") String nombre,
                    @JsonProperty("user_password")String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
