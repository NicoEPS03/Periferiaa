package com.periferia.prueba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Titulo es obligatorio")
    @Size(min = 3, max = 10, message = "El titulo debe tener entre 3 y 10 caracteres")
    @Column(name = "titulo", length = 10, nullable = false)
    private String titulo;
    @NotNull(message = "Descripcion es obligatoria")
    @Size(min = 5, max = 20, message = "La descripcion debe tener entre 5 y 20 caracteres")
    @Column(name = "descripcion", length = 20, nullable = false)
    private String descripcion;

    public Tarea(Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Tarea() {

    }
}
