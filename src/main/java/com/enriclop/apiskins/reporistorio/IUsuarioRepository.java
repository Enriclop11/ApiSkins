package com.enriclop.apiskins.reporistorio;

import com.enriclop.apiskins.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.username like concat('%', ?1, '%')")
    List<Usuario> findByUsernameLike(String username);
}
