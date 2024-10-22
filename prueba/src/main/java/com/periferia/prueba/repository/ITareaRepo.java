package com.periferia.prueba.repository;

import com.periferia.prueba.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepo extends JpaRepository<Tarea, Integer> {
}
