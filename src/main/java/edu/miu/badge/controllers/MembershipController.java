package edu.miu.badge.controllers;

import edu.miu.badge.domains.Membership;
import edu.miu.badge.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
