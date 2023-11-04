package com.enriclop.apiskins.reporistorio;

import com.enriclop.apiskins.modelo.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkinRepository extends JpaRepository<Skin, Integer> {
}
