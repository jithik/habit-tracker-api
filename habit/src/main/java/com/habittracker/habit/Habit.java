package com.habittracker.habit;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity 
public class Habit {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    protected Habit()
    {
       
    }

    public Habit (String name)
    {
        this.name= name;
    }

    @PrePersist 
    void onCreate()
    {
        this.createdAt=Instant.now();
    }
}
