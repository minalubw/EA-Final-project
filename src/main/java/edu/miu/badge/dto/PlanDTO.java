package edu.miu.badge.dto;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.PlanType;
import edu.miu.badge.domains.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PlanDTO {
    private Integer id;
    private String name;
    private String description;
    private List<PlanType> planTypes;
    private List<Location> locations;
    private List<Roles> allowedRoles;
}
