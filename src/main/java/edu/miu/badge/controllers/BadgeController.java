package edu.miu.badge.controllers;


import edu.miu.badge.dto.RequestBadgeDTO;
import edu.miu.badge.dto.ResponseBadgeDTO;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @GetMapping
    public ResponseEntity<?> getBadges() {                                             // get all badges
        return new ResponseEntity<List<ResponseBadgeDTO>>(badgeService.getAllBadges(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBadge(@PathVariable int id) {                          // get a badge by id
        try {
            return new ResponseEntity<ResponseBadgeDTO>(badgeService.getBadge(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addBadge(@RequestBody RequestBadgeDTO badge) {                                    // add a badge
        try {
            ResponseBadgeDTO newBadge = badgeService.createBadge(badge);
            return new ResponseEntity<ResponseBadgeDTO>(newBadge, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBadge(@PathVariable int id, @RequestBody RequestBadgeDTO badge) {           // update a badge
        try {
            ResponseBadgeDTO updatedBadge = badgeService.updateBadge(id, badge);
            return new ResponseEntity<ResponseBadgeDTO>(updatedBadge, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inactiveBadge(@PathVariable int id) {                        // inactive a badge
        try {
            return new ResponseEntity<String>(badgeService.inactiveBadge(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
