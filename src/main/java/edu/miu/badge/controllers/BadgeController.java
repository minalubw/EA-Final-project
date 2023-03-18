package edu.miu.badge.controllers;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.exceptions.BadgeNotFoundException;
import edu.miu.badge.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @GetMapping("/badges")
    public ResponseEntity<?> getBadges() {                                             // get all badges
        return new ResponseEntity<String>(badgeService.getAllBadges().toString(), HttpStatus.OK);
    }

    @GetMapping("/badges/{id}")
    public ResponseEntity<?> getBadge(@PathVariable int id) {                          // get a badge by id
        try {
            return new ResponseEntity<String>(badgeService.getBadge(id).toString(), HttpStatus.OK);
        } catch (BadgeNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/badges")
    public ResponseEntity<?> addBadge(@RequestBody Badge badge) {                                    // add a badge
        Badge newBadge = badgeService.createBadge(badge);
        return new ResponseEntity<Badge>(newBadge, HttpStatus.OK);
    }

    @PutMapping("/badges/{id}")
    public ResponseEntity<?> updateBadge(@PathVariable int id, @RequestBody Badge badge) {           // update a badge
        try {
            Badge updatedBadge = badgeService.updateBadge(id, badge);
            return new ResponseEntity<Badge>(updatedBadge, HttpStatus.OK);
        } catch (BadgeNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/badges/{id}")
    public ResponseEntity<?> inactiveBadge(@PathVariable int id) {                        // inactive a badge
        try {
            return new ResponseEntity<String>(badgeService.inactiveBadge(id), HttpStatus.OK);
        } catch (BadgeNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
