package com.example.demo.controllers;

import com.example.demo.models.Movement;
import com.example.demo.services.MovementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movement")
@AllArgsConstructor
public class MovementController {
    private final MovementService movementService;

    @PostMapping
    public Movement create(@Valid @RequestBody Movement movement) throws Exception {
        return movementService.create(movement);
    }

    @GetMapping("index")
    public List<Movement> index() {
        return movementService.index();
    }
//
//    @PutMapping("/{id}")
//    public Movement update(@PathVariable Long id, @Valid @RequestBody Movement movement) {
//        return movementService.update(id, movement);
//    }
}
