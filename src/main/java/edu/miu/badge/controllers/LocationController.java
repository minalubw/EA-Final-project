/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.miu.badge.controllers;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.TimeSlot;
import edu.miu.badge.dto.LocationDTO;
import edu.miu.badge.dto.TimeSlotDTO;
import edu.miu.badge.enumeration.LocationType;
import edu.miu.badge.services.LocationService;
import edu.miu.badge.services.TimeSlotService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@RestController
@RequestMapping("/location")
public class LocationController {
    
    @Autowired
    private LocationService locationService;
    
    @GetMapping("/all")
    public List<Location> getAllLocationss(){
        return locationService.getAllLocations();
    }
    
    @PostMapping("/add")
    public Location add(@RequestBody LocationDTO locationDTO){
        return locationService.createLocation(locationDTO);
    }
    @GetMapping("/test")// this is just for testing...
    public String testt(){
        List<TimeSlotDTO> tsdto = new ArrayList();
        tsdto.add(new TimeSlotDTO(LocalDateTime.now(), LocalDateTime.now().plusDays(10)));
        tsdto.add(new TimeSlotDTO(LocalDateTime.now(), LocalDateTime.now().plusDays(20)));
        LocationDTO ldto = new LocationDTO("gym hall", "this is gym", 90, LocationType.GYMNASIUM, tsdto);
        locationService.createLocation(ldto);
        return "time slot added for test";
    }
    @PutMapping("/{id}")
    public Location update(@PathVariable Long id, @RequestBody LocationDTO locationDTO){
        return locationService.updateLocation(id, locationDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        locationService.deleteLocation(id);
    }
}

