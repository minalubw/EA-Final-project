package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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
    @Column(nullable = false)
    @JoinTable(name = "Plan_Plantypes")
    private List<PlanType> planTypes;

    @OneToMany
    @Column(name = "Plan_Locations", nullable = false)
    private List<Location> locations;

    @OneToMany
    @JoinTable(name = "Plan_Roles")
    @Column(nullable = false)
    private List<Role> allowedRoles;

}
