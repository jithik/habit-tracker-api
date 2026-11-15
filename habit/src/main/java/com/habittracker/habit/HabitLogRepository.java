package com.habittracker.habit;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitLogRepository  extends JpaRepository<HabitLog, Long>
{
  boolean existsByHabitIdAndDate(Long habitId, LocalDate date);
  void deleteByHabitIdAndDate(Long habitId, LocalDate date);
}
