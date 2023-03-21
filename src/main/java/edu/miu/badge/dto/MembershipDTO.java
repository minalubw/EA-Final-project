package edu.miu.badge.dto;

import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Plan;
import edu.miu.badge.domains.PlanType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDTO {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Member member;
    private Plan plan;
    private PlanType planType;
    private int numberOfAllowance;
}
