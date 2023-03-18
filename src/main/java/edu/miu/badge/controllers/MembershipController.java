package edu.miu.badge.controllers;

import edu.miu.badge.domains.Membership;
import edu.miu.badge.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @GetMapping("/memberships/{membershipId}")
    public ResponseEntity<?> getOneMembershipById(@PathVariable int membershipId){
        Membership memberShip =  membershipService.getOneMembershipById(membershipId);
        return new ResponseEntity<Membership>(memberShip, HttpStatus.OK);
    }
    @GetMapping("/memberships")
    public ResponseEntity<?> getAll(@PathVariable int membershipId){
        Collection<Membership> memberships =  membershipService.getAll();
        return new ResponseEntity<Collection<Membership>>(memberships, HttpStatus.OK);
    }

    @PostMapping("/memberships")
    public ResponseEntity<?> create(@RequestBody Membership membership){
        Membership membership1 =  membershipService.create(membership);
        return new ResponseEntity<Membership>(membership1, HttpStatus.OK);
    }

    @PutMapping("/memberships/{membershipId}")
    public ResponseEntity<?> update(@PathVariable int membershipId, @RequestBody Membership membership){
        Membership membership1 =  membershipService.update(membership);
        return new ResponseEntity<Membership>(membership1, HttpStatus.OK);
    }

}
