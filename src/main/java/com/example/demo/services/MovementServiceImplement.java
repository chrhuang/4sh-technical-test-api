package com.example.demo.services;

import com.example.demo.models.Movement;
import com.example.demo.repositories.MovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class MovementServiceImplement implements MovementService {
    private final MovementRepository movementRepository;

    @Override
    public Movement create(Movement movement) throws Exception {
        String reference = movement.getReference();
        if (!movement.getEntry() && movementRepository.findByReference(reference) == null) {
            throw new Exception("this reference doesn't exist");
        }
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> index() {
        return movementRepository.findFirst50ByOrderByCreatedAtDesc();
    }
}
