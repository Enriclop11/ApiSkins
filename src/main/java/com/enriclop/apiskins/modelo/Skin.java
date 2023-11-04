package com.enriclop.apiskins.modelo;

import com.enriclop.apiskins.enums.Color;
import com.enriclop.apiskins.enums.TipoSkin;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "skins")
@Data
public class Skin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private TipoSkin tipo;

    private double precio;

    private String descripcion;

    private Color color;

    public Skin() {
    }

    public Skin(String nombre, TipoSkin tipo, double precio, String descripcion, Color color) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.color = color;
    }

}
