package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.reporistorio.ISkinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinService implements ISkinService {

    private ISkinRepository skinRepository;

    public SkinService(ISkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    @Override
    public List<Skin> getSkins() {
        return skinRepository.findAll();
    }

    @Override
    public Skin getSkinById(Integer id) {
        return skinRepository.findById(id).get();
    }

    @Override
    public Skin saveSkin(Skin skin) {
        return skinRepository.save(skin);
    }

    public List<Skin> saveSkins(List<Skin> skins) {
        return skinRepository.saveAll(skins);
    }

    @Override
    public Skin updateSkin(Skin skin) {
        return skinRepository.save(skin);
    }

    @Override
    public void deleteSkinById(Integer id) {
        skinRepository.deleteById(id);
    }
}
