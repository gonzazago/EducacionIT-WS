package com.eduit.ws.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Libro {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("author")
    private String autor;
    @JsonProperty("imported")
    private boolean nacional;

   @JsonCreator
    public Libro( @JsonProperty("id") Long id,
                  @JsonProperty("title") String titulo,
                  @JsonProperty("author") String autor,
                  @JsonProperty("imported") boolean nacional) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.nacional = nacional;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isNacional() {
        return nacional;
    }

}
