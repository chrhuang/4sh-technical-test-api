package com.example.demo.controllers;

import com.example.demo.models.Movement;
import com.example.demo.services.EmailSenderService;
import com.example.demo.services.MovementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movement")
@AllArgsConstructor
public class MovementController {
    @Autowired
    private EmailSenderService senderService;
    private final MovementService movementService;

    @PostMapping
    public Movement create(@Valid @RequestBody Movement movement) throws Exception {
        Movement result = movementService.create(movement);
        senderService.sendMovement(result);
        return result;
    }
    @GetMapping("index")
    public List<Movement> index() {
        return movementService.index();
    }
}
