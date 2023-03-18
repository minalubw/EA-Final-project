package edu.miu.badge.services;

import edu.miu.badge.dto.PlanDTO;

import java.util.List;

public interface PlanService  {
    PlanDTO createPlan(PlanDTO planDTO);
    PlanDTO getPlanById(Integer id);
    PlanDTO updatePlan(Integer id, PlanDTO planDTO);
    String deletePlan(Integer id);
    List<PlanDTO> getAllPlans();
}
