package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Schedule;
import com.example.demo.repositories.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> Get() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule Get(Integer id) {
        return scheduleRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Schedule model) {
        scheduleRepository.save(model);
        return scheduleRepository.findById(model.getSchedule_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        scheduleRepository.deleteById(id);
        return !scheduleRepository.findById(id).isPresent();
    }
}
