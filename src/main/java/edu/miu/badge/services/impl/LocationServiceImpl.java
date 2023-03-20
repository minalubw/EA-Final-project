package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.dto.LocationDTO;
import edu.miu.badge.dto.TimeSlotDTO;
import edu.miu.badge.repositories.LocationRepository;
import edu.miu.badge.services.LocationService;
import edu.miu.badge.services.TimeSlotService;
import java.util.ArrayList;
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
public class LocationServiceImpl implements LocationService {

    @Autowired
    private TimeSlotService timeSlotService;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setLocationId(null);
        location.setLocationName(locationDTO.getLocationName());
        location.setDescription(locationDTO.getDescription());
        location.setCapacity(locationDTO.getCapacity());
        location.setLocationType(locationDTO.getLocationType());
        location.setTimeSlots(new ArrayList<TimeSlot>());
        if (locationDTO.getTimeslots() != null) {
            for (TimeSlotDTO timeSlotDTO : locationDTO.getTimeslots()) {
                location.getTimeSlots().add(timeSlotService.createTimeSlot(timeSlotDTO));
            }
        }

        return locationRepository.save(location);

    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location updateLocation(Long id, LocationDTO locationDTO) {
        Location old = getLocationById(id);
        old.setLocationName(locationDTO.getLocationName());
        old.setDescription(locationDTO.getDescription());
        old.setCapacity(locationDTO.getCapacity());
        old.setLocationType(locationDTO.getLocationType());
        //old.setTimeSlots(new ArrayList<TimeSlot>());
        return locationRepository.save(old);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

}
