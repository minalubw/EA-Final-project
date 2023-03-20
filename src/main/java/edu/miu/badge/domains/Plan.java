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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Plan_Plantypes")
    @Column(nullable = false)
    private List<PlanType> planTypes;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Location> locations;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Roles> allowedRoles;

}
