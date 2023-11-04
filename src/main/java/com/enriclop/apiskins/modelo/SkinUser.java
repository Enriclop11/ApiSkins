package com.enriclop.apiskins.modelo;

import com.enriclop.apiskins.enums.Color;
import com.enriclop.apiskins.enums.TipoSkin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "skin_user")
@Data
public class SkinUser extends Skin{
    @Column(name = "usuario_id", nullable = false)
    private int idUsuario;

    private Date fechaCompra;

    public SkinUser() {
        super();
    }

    public SkinUser(int idUsuario, String nombre, TipoSkin tipo, double precio, Color color, String descripcion) {
        super(nombre, tipo, precio, descripcion, color);
        this.idUsuario = idUsuario;
        //Si no introduce la fecha introducimos la fecha actual
        this.fechaCompra = new java.sql.Date(System.currentTimeMillis());
    }

    public SkinUser(int idUsuario, String nombre, TipoSkin tipo, double precio, Color color, String descripcion, Date fechaCompra) {
        super(nombre, tipo, precio, descripcion, color);
        this.idUsuario = idUsuario;
        this.fechaCompra = fechaCompra;
    }

    public SkinUser(Skin skin, int idUsuario) {
        super(skin.getNombre(), skin.getTipo(), skin.getPrecio(), skin.getDescripcion(), skin.getColor());
        this.idUsuario = idUsuario;
        //Si no introduce la fecha introducimos la fecha actual
        this.fechaCompra = new java.sql.Date(System.currentTimeMillis());
    }
}
