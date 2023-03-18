package edu.miu.badge.controllers;

import edu.miu.badge.domains.TimeSlot;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
    
    public List<TimeSlot> getAllTimeslots(){
        return null;
    }
}
