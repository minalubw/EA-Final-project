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
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany
    @JoinTable(name = "Plan_Plantypes")
    private List<PlanType> planTypes;

    @OneToMany
    private List<Location> locations;

    @OneToMany
    @JoinTable(name = "Plan_Roles")
    private List<Role> allowedRoles;

}
