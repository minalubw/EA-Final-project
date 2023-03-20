package edu.miu.badge.controllers;

import edu.miu.badge.domains.HttpResponse;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.services.MemberService;
import edu.miu.badge.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members", produces = "application/json")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<HttpResponse> createMember(@RequestBody MemberDTO memberDTO){
        memberService.insertNewMember(memberDTO);
        return responseResponseEntity(HttpStatus.OK, "New member added Successfully!");
    }

    private ResponseEntity<HttpResponse> responseResponseEntity(HttpStatus httpStatus, String message){
        HttpResponse httpResponse = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),  message);
        return new ResponseEntity<>(httpResponse, httpStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberById(@PathVariable int id){
        try {
            return new ResponseEntity<MemberDTO>(memberService.getMemberById(id), HttpStatus.OK);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable int id){
        try {
            return new ResponseEntity<String>(memberService.deleteMemberById(id), HttpStatus.OK);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/memberships")
    public ResponseEntity<?> getMembershipsByMemberId(@PathVariable int id) {
        try {
            return new ResponseEntity<>(membershipService.getMembershipsByMemberId(id), HttpStatus.OK);
        } catch (MemberNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @PutMapping("/{memberid}")
    public ResponseEntity<?> updateMember(@PathVariable("memberid") int id, @RequestBody MemberDTO memberDTO){
        try {
            return new ResponseEntity<>(memberService.updateMember(id, memberDTO), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
