package com.enriclop.apiskins.controller;

import com.enriclop.apiskins.enums.Color;
import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.modelo.SkinUser;
import com.enriclop.apiskins.modelo.Usuario;
import com.enriclop.apiskins.servicio.SkinService;
import com.enriclop.apiskins.servicio.SkinUserService;
import com.enriclop.apiskins.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SkinService skinService;

    @Autowired
    private SkinUserService skinUserService;

    @PostMapping("/users/new")
    public ResponseEntity<Usuario> newUser(@ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("email") String email) {
        Usuario user = new Usuario(username, password, email);
        usuarioService.saveUsuario(user);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/skins/myskins/")
    public List<SkinUser> getMySkins(@ModelAttribute("username") String username) {
        return usuarioService.getUsuarioByUsername(username).getSkins();
    }

    @PostMapping("/skins/buy")
    public ResponseEntity<Usuario> buySkin(@ModelAttribute("skin") Integer idSkin, @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        Usuario user = usuarioService.getUsuarioByUsernameAndPasword(username, password);
        Skin newSkin = skinService.getSkinById(idSkin);

        if (user == null) {
            return ResponseEntity.notFound().build();
        } else if (newSkin == null) {
            return ResponseEntity.badRequest().build();
        } else if (user.getDinero() < newSkin.getPrecio()) {
            return ResponseEntity.badRequest().build();
        }

        SkinUser skin = new SkinUser(newSkin, user);
        skinUserService.saveSkin(skin);
        user.setDinero(user.getDinero() - newSkin.getPrecio());
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
        skinUserService.saveSkin(skin);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/skins/delete/{idSkin}")
    public ResponseEntity<Usuario> deleteSkin(@ModelAttribute("idSkin") Integer idSkin, @ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        Usuario user = usuarioService.getUsuarioByUsernameAndPasword(username, password);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        SkinUser skin = user.getSkinById(idSkin);

        if (skin == null) {
            return ResponseEntity.notFound().build();
        }

        skinUserService.deleteSkinById(skin.getId());

        return ResponseEntity.ok(usuarioService.getUsuarioByUsernameAndPasword(username, password));
    }
}
