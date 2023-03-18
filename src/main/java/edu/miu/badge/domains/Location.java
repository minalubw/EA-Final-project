package edu.miu.badge.domains;

import edu.miu.badge.enums.LocationType;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity @Table(name = "locations")
@Setter @Getter @AllArgsConstructor
@NoArgsConstructor @ToString

public class Location {
    @Id
    @GeneratedValue
    private int locationId;
    
    private String locationName;
    private String description;
    private int capacity;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TimeSlot> timeSlots;
    
    private LocationType locationType;
}
