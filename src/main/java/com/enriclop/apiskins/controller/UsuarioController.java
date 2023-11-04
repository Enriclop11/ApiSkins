package com.enriclop.apiskins.controller;

import com.enriclop.apiskins.enums.Color;
import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.modelo.SkinUser;
import com.enriclop.apiskins.modelo.Usuario;
import com.enriclop.apiskins.servicio.SkinService;
import com.enriclop.apiskins.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SkinService skinService;

    @PostMapping("/users/new")
    public ResponseEntity<Usuario> newUser(@ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("email") String email) {
        Usuario user = new Usuario(username, password, email);
        usuarioService.saveUsuario(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/skins/buy")
    public ResponseEntity<Usuario> buySkin(@ModelAttribute("skin") Integer idSkin, @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        Usuario user = usuarioService.getUsuarioByUsernameAndPasword(username, password);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Skin newSkin = skinService.getSkinById(idSkin);
        user.addSkin(newSkin);
        usuarioService.saveUsuario(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/skins/color")
    public ResponseEntity<Usuario> changeColor(@ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("skin") Integer idSkin, @ModelAttribute("color") Color color) {
        Usuario user = usuarioService.getUsuarioByUsernameAndPasword(username, password);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        SkinUser skin = user.getSkinById(idSkin);
        skin.setColor(color);
        usuarioService.saveUsuario(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/skins/delete/{id}")
    public ResponseEntity<Usuario> deleteSkin(@ModelAttribute("skin") Integer idSkin, @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        Usuario user = usuarioService.getUsuarioByUsernameAndPasword(username, password);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        SkinUser skin = user.getSkinById(idSkin);

        user.removeSkin(skin);
        usuarioService.saveUsuario(user);
        return ResponseEntity.ok(user);
    }
}
