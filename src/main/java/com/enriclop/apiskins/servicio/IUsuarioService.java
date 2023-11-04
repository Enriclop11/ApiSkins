package com.enriclop.apiskins.servicio;

import com.enriclop.apiskins.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuarioByUsername(String username);

    Usuario getUsuarioByUsernameAndPasword(String nombre, String password);

    Usuario saveUsuario(Usuario usuario);

    Usuario getUsuarioById(Integer id);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuarioById(Integer id);
}
