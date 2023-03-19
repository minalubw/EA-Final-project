package edu.miu.badge.services;

import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.dto.TimeSlotDTO;
import java.util.List;

/**
 *
 * @author Daniel Tsegay Meresie
 */
public interface TimeSlotService {
    TimeSlot createTimeSlot(TimeSlotDTO timeSlotDTO);
    TimeSlot getTimeSlotById(Long id);
    TimeSlot updateTimeSlot(Long id, TimeSlotDTO timeSlotDTO);
    void deleteTimeSlot(Long id);
    List<TimeSlot> getAllTimeSlots();
}
