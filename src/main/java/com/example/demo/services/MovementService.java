package com.example.demo.services;

import com.example.demo.models.Movement;

import java.util.List;

public interface MovementService {
    Movement create(Movement movement) throws Exception;
//    List<Movement> index();
//    Movement update(Long id, Movement movement);
}
