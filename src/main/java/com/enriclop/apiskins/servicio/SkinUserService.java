package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.modelo.SkinUser;
import com.enriclop.apiskins.reporistorio.ISkinUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinUserService implements ISkinUserService {

    private ISkinUserRepository skinUserRepository;

    public SkinUserService(ISkinUserRepository skinUserRepository) {
        this.skinUserRepository = skinUserRepository;
    }

    @Override
    public List<SkinUser> getSkins() {
        return skinUserRepository.findAll();
    }

    @Override
    public SkinUser getSkinById(Integer id) {
        return skinUserRepository.findById(id).get();
    }

    @Override
    public List<SkinUser> getSkinsByUserId(Integer id) {
        return skinUserRepository.findByUsuario_Id(id);
    }


    @Override
    public SkinUser saveSkin(SkinUser skin) {
        return skinUserRepository.save(skin);
    }

    @Override
    public List<SkinUser> saveSkins(List<SkinUser> skins) {
        return skinUserRepository.saveAll(skins);
    }

    @Override
    public SkinUser updateSkin(SkinUser skin) {
        return skinUserRepository.save(skin);
    }

    @Override
    public void deleteSkinById(Integer id) {
        skinUserRepository.deleteById(id);
    }
}

