package com.habittracker.habit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateHabitRequest(
    @NotBlank(message="Habit Name is required") 
    @Size(max=50, message="Habit Name must be at most 50 characters long") 
    String name) {


}
