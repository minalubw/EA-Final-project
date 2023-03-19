package edu.miu.badge.services;

import edu.miu.badge.domains.Location;
import edu.miu.badge.dto.LocationDTO;
import java.util.List;

/**
 *
 * @author Daniel Tsegay Meresie
 */
public interface LocationService {
    Location createLocation(LocationDTO locationDTO);
    Location getLocationById(Long id);
    Location updateLocation(Long id, LocationDTO locationDTO);
    void deleteLocation(Long id);
    List<Location> getAllLocations();
}
