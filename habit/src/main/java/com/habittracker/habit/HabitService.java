package com.habittracker.habit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service 
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    public HabitService(HabitRepository habitRepository,HabitLogRepository habitLogRepository)
    {
        this.habitRepository=habitRepository;
        this.habitLogRepository=habitLogRepository;
    }


    public Habit create(String name)
    {
        Habit habit= new Habit(name);
        return habitRepository.save(habit);
    }

    public List<Habit> findAll()
    {
        return habitRepository.findAll();
    }

    public void complete(Long habitId)
    {
        if(!habitRepository.existsById(habitId))
        {
           throw new HabitNotFoundException("Habit not found");
        }
         LocalDate todayDate= LocalDate.now();
            if(!habitLogRepository.existsByHabitIdAndDate(habitId, todayDate))
            {
                habitLogRepository.save(new HabitLog(habitId, todayDate));
            }     
    }

    @Transactional 
    public void undoComplete(Long habitId)
    {
        if(!habitRepository.existsById(habitId))
        {
            throw new HabitNotFoundException("Habit Not found");
        } 
        habitLogRepository.deleteByHabitIdAndDate(habitId, LocalDate.now());
    }
}
