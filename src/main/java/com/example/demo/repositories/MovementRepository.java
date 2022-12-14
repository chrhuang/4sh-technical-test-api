package com.example.demo.repositories;

import com.example.demo.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    Movement findByReference(String reference);

    List<Movement> findFirst50ByOrderByCreatedAtDesc();
}
