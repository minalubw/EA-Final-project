package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Membership1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="[membership_id]")
    private int id;
    @Column(name="start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name="end_date", nullable = false)
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name="plan_id", nullable = false)
    private Plan plan;
    @ManyToOne
    @JoinColumn(name="plan_type_id", nullable = false)
    private PlanType planType;
    @Column(name="number_of_allowance")
    private int numberOfAllowance;
}
