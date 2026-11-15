package com.habittracker.habit;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService)
    {
        this.habitService=habitService;
    }

    @PostMapping
    public ResponseEntity<Habit> create(@Valid @RequestBody CreateHabitRequest request)
    {
        Habit createdHabit=habitService.create(request.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHabit);
    }

    @GetMapping
    public ResponseEntity<List<Habit>> findAll()
    {
        return ResponseEntity.ok(habitService.findAll());
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Void> complete(@PathVariable Long id)
    {
        habitService.complete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> undoComplete(@PathVariable Long id)
    {
        habitService.undoComplete(id);
        return ResponseEntity.noContent().build();
    }
}
