package com.enriclop.apiskins.modelo;

import com.enriclop.apiskins.enums.Color;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dinero")
    private double dinero;

    //Skins owned by the user
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private ArrayList<SkinUser> skins;

    public Usuario() {
    }

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.email = email;
        this.dinero = 1000;
        this.skins = new ArrayList<>();
    }

    public void addSkin(Skin skin) {
        this.skins.add(new SkinUser(skin, this.id));
    }

    public void removeSkin(SkinUser skin) {
        this.skins.remove(skin);
    }

    public SkinUser getSkinById(Integer id) {
        for (SkinUser skin : this.skins) {
            if (skin.getId() == id) {
                return skin;
            }
        }
        return null;
    }

    public boolean login(String password) {
        return new BCryptPasswordEncoder().matches(password, this.password);
    }
}
