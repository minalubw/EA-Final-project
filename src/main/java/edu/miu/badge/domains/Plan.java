package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "plan_table")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PlanType> planTypes;

    public Plan(String name, String description, List<PlanType> planTypes) {
        this.name = name;
        this.description = description;
        this.planTypes = planTypes;
    }

}
