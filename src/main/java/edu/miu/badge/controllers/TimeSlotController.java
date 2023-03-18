package edu.miu.badge.controllers;

import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.repositories.TimeSlotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
    
    @Autowired
    TimeSlotRepository timeSlotRepository;
    
    @GetMapping("/all")
    public List<TimeSlot> getAllTimeslots(){
        return timeSlotRepository.findAll();
    }
    
    @PostMapping("/")
    public TimeSlot add(TimeSlot ts){
        return timeSlotRepository.save(ts);
    }
    
}
