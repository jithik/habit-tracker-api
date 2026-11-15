package com.habittracker.habit;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(uniqueConstraints = @UniqueConstraint (columnNames = {"habit_id", "date"}))
public class HabitLog {

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public Long getHabitId() {
        return habitId;
    }
    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private Long habitId;
    private LocalDate date;


    public HabitLog(Long habitId, LocalDate date)
    {
        this.habitId=habitId;
        this.date=date;
    }

    protected HabitLog()
    {

    }



}
