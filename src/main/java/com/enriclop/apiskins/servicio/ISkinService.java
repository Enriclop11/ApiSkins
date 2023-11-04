package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Skin;

import java.util.List;

public interface ISkinService {

    List<Skin> getSkins();

    Skin getSkinById(Integer id);

    Skin saveSkin(Skin skin);

    List<Skin> saveSkins(List<Skin> skins);

    Skin updateSkin(Skin skin);

    void deleteSkinById(Integer id);
}
