package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="[start_date]", nullable = false)
    private LocalDate startDate;
    @Column(name="[end_date]", nullable = false)
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name="[member_id]", nullable = false)
    private Member member;
    @ManyToOne
    @JoinColumn(name="[plan_id]", nullable = false)
    private Plan plan;
    @ManyToOne
    @JoinColumn(name="[plan_type_id]", nullable = false)
    private PlanType planType;
    @Column(name="[number_of_allowance]")
    private int numberOfAllowance;
}
