package edu.miu.badge.domains;


import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter
@NoArgsConstructor
@ToString
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
