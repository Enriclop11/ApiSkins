package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Usuario;
import com.enriclop.apiskins.reporistorio.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getUsuarioByUsername(String username) {
        return usuarioRepository.findByUsernameLike(username);
    }

    @Override
    public Usuario getUsuarioByUsernameAndPasword(String nombre, String password) {
        Usuario user = usuarioRepository.findByUsernameLike(nombre).get(0);
        if (user == null) {
            return null;
        }
        if (user.login(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
