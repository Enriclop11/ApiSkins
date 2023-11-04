package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.modelo.SkinUser;

import java.util.List;

public interface ISkinUserService {

    List<SkinUser> getSkins();

    SkinUser getSkinById(Integer id);

    List<SkinUser> getSkinsByUserId(Integer id);

    SkinUser saveSkin(SkinUser skin);

    List<SkinUser> saveSkins(List<SkinUser> skins);

    SkinUser updateSkin(SkinUser skin);

    void deleteSkinById(Integer id);
}
