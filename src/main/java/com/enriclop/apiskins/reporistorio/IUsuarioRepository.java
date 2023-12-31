package com.enriclop.apiskins.reporistorio;

import com.enriclop.apiskins.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.username like ?1")
    Usuario findByUsernameLike(String username);


}
