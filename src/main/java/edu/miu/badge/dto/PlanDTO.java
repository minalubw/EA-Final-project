package edu.miu.badge.dto;

import edu.miu.badge.domains.PlanType;
import jakarta.persistence.OneToMany;
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

    public PlanDTO(String name, String description, List<PlanType> planTypes) {
        this.name = name;
        this.description = description;
        this.planTypes = planTypes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
