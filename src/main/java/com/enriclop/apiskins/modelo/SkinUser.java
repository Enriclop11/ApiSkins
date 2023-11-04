package com.enriclop.apiskins.modelo;

import com.enriclop.apiskins.enums.Color;
import com.enriclop.apiskins.enums.TipoSkin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "skin_user")
@Data
public class SkinUser extends Skin{

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    private Date fechaCompra;

    public SkinUser() {
        super();
    }

    public SkinUser(Usuario usuario, String nombre, TipoSkin tipo, double precio, Color color, String descripcion) {
        super(nombre, tipo, precio, descripcion, color);
        this.usuario = usuario;
        //Si no introduce la fecha introducimos la fecha actual
        this.fechaCompra = new java.sql.Date(System.currentTimeMillis());
    }

    public SkinUser(Usuario usuario, String nombre, TipoSkin tipo, double precio, Color color, String descripcion, Date fechaCompra) {
        super(nombre, tipo, precio, descripcion, color);
        this.usuario = usuario;
        this.fechaCompra = fechaCompra;
    }

    public SkinUser(Skin skin, Usuario usuario) {
        super(skin.getNombre(), skin.getTipo(), skin.getPrecio(), skin.getDescripcion(), skin.getColor());
        this.usuario = usuario;
        //Si no introduce la fecha introducimos la fecha actual
        this.fechaCompra = new java.sql.Date(System.currentTimeMillis());
    }
}
