package edu.miu.badge.services;

import edu.miu.badge.domains.Location;
import edu.miu.badge.dto.LocationDTO;
import java.util.List;

/**
 *
 * @author Daniel Tsegay Meresie
 */
public interface LocationService {
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO getLocationById(Long id);
    LocationDTO updateLocation(Long id, LocationDTO locationDTO);
    void deleteLocation(Long id);
    List<LocationDTO> getAllLocations();
}
