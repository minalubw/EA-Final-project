package edu.miu.badge.dto;

import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.enums.LocationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Setter @Getter @AllArgsConstructor
@NoArgsConstructor @ToString

public class locationDTO {
    private int locationId;
    
    private String locationName;
    private String description;
    private int capacity;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Integer> timeSlotIds;
    
    private LocationType locationType;
}
