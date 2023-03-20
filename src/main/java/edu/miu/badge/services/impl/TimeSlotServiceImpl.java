package edu.miu.badge.services.impl;

import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.dto.TimeSlotDTO;
import edu.miu.badge.repositories.TimeSlotRepository;
import edu.miu.badge.services.TimeSlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Service
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService{
    @Autowired
    TimeSlotRepository timeSlotRepository;
    @Override
    public TimeSlot createTimeSlot(TimeSlotDTO timeSlotDTO) {
        TimeSlot ts = new TimeSlot();
        ts.setTimeSlotId(null);
        ts.setStartTime(timeSlotDTO.getStartTime());
        ts.setEndTime(timeSlotDTO.getEndTime());
        return timeSlotRepository.save(ts);
    }

    @Override
    public TimeSlot getTimeSlotById(Long id) {
        return timeSlotRepository.findById(id).get();
    }

    @Override
    public TimeSlot updateTimeSlot(Long id, TimeSlotDTO timeSlotDTO) {
        TimeSlot old = getTimeSlotById(id);
        old.setEndTime(timeSlotDTO.getEndTime());
        old.setStartTime(timeSlotDTO.getStartTime());
        return timeSlotRepository.save(old);
    }

    @Override
    public void deleteTimeSlot(Long id) {
        timeSlotRepository.delete(getTimeSlotById(id));
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }
    
}
