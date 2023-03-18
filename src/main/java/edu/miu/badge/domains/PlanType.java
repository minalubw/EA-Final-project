package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PlanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private PlanTypeEnum planType;

    public PlanType(PlanTypeEnum planType) {
        this.planType = planType;
    }

    public enum PlanTypeEnum{
        LIMITED, UNLIMITED, CHECKER;
    }
}
