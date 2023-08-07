package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.services.ScheduleService;

@SpringBootTest
public class ScheduleTest {
    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void Save(){
        Boolean expected = true;

        com.example.demo.entities.Schedule schedule = new com.example.demo.entities.Schedule();
        schedule.setSchedule_id(29);
        schedule.setCapacity(21);

        Boolean result = scheduleService.Save(schedule);

        assertEquals(expected, result);
    }

    @Test
    public void Delete(){
        Boolean expected = true;
        Integer schedule_id = 9;

        Boolean result = scheduleService.Delete(schedule_id);

        assertEquals(expected, result);
    }
}
