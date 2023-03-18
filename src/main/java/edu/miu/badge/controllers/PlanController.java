package edu.miu.badge.controllers;

import edu.miu.badge.dto.PlanDTO;
import edu.miu.badge.exceptions.PlanNotFoundException;
import edu.miu.badge.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping("/{planid}")
    public ResponseEntity<?> getOnePlan(@PathVariable("planid") Integer id){
        return new ResponseEntity<>(planService.getPlanById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllPlans(){
        return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addPlan(@RequestBody PlanDTO planDTO){
        return new ResponseEntity<>(planService.createPlan(planDTO), HttpStatus.OK);
    }

    @PutMapping("/{planid}")
    public ResponseEntity<?> updatePlan(@PathVariable("planid") Integer id, @RequestBody PlanDTO planDTO){
        try {
            return new ResponseEntity<>(planService.updatePlan(id, planDTO), HttpStatus.OK);
        }catch (PlanNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{planid}")
    public ResponseEntity<?> updatePlan(@PathVariable("planid") Integer id){
        try {
            return new ResponseEntity<>(planService.deletePlan(id), HttpStatus.OK);
        }catch (PlanNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
