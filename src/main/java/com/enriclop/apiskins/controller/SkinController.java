package com.enriclop.apiskins.controller;

import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.servicio.SkinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkinController {

    @Autowired
    private SkinService skinService;

    @GetMapping("/skins/available")
    public List<Skin> listSkins() {
        return skinService.getSkins();
    }

    @GetMapping("/skins/getskin/{id}")
    public Skin getSkinById(@PathVariable Integer id) {
        return skinService.getSkinById(id);
    }

}
