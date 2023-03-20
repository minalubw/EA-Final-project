package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.Plan;
import edu.miu.badge.dto.LocationDTO;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.dto.PlanDTO;
import edu.miu.badge.exceptions.PlanNotFoundException;
import edu.miu.badge.repositories.PlanRepository;
import edu.miu.badge.services.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        return modelMapper.map(planRepository.save(modelMapper.map(planDTO, Plan.class)), PlanDTO.class);
    }

    @Override
    public PlanDTO getPlanById(Integer id) {
        return modelMapper.map(planRepository.findById(id), PlanDTO.class);
    }

    @Override
    public PlanDTO updatePlan(Integer id, PlanDTO planDTO) {
        Optional<Plan> planOptional = planRepository.findById(id);
        if(planOptional.isPresent()){
            Plan toBeUpdated = planOptional.get();
            toBeUpdated.setName(planDTO.getName());
            toBeUpdated.setDescription(planDTO.getDescription());
            toBeUpdated.setLocations(planDTO.getLocations());
            toBeUpdated.setAllowedRoles(planDTO.getAllowedRoles());
            toBeUpdated.setPlanTypes(planDTO.getPlanTypes());
            return modelMapper.map(planRepository.save(toBeUpdated), PlanDTO.class);
        }
        else{
            throw new PlanNotFoundException("Plan with an id " + id + " doesn't exist");
        }
    }

    @Override
    public String deletePlan(Integer id) {
        Optional<Plan> planOptional = planRepository.findById(id);
        if(planOptional.isPresent()){
           planRepository.delete(planOptional.get());
           return "Plan with id " + id + " deleted!";
        }
        else{
            throw new PlanNotFoundException("Plan with an id " + id + " doesn't exist");
        }
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        return planRepository.findAll().stream()
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> getLocationsForPlan(Integer id) {
        List<LocationDTO> locationDTOS = new ArrayList<>();
        Optional<Plan> planOptional = planRepository.findById(id);
        if(planOptional.isPresent()){
            for (Location l: planOptional.get().getLocations()) {
                locationDTOS.add(modelMapper.map(l, LocationDTO.class));
            }
            return locationDTOS;
        }else {
            throw new PlanNotFoundException("Plan with an id " + id + " doesn't exist");
        }
    }
}
