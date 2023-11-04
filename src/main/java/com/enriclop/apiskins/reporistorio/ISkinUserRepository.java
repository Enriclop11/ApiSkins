package com.enriclop.apiskins.reporistorio;

import com.enriclop.apiskins.modelo.SkinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkinUserRepository extends JpaRepository<SkinUser, Integer> {
    @Query("select s from SkinUser s where s.usuario.id = ?1")
    List<SkinUser> findByUsuario_Id(int id);



}