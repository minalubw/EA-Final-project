package edu.miu.badge.controllers;

import edu.miu.badge.domains.HttpResponse;
import edu.miu.badge.dto.ResponseBadgeDTO;
import edu.miu.badge.dto.RequestMemberDTO;
import edu.miu.badge.dto.ResponseMemberDTO;
import edu.miu.badge.dto.TransactionDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.services.MemberService;
import edu.miu.badge.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/members", produces = "application/json")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<ResponseMemberDTO> createMember(@RequestBody RequestMemberDTO requestMemberDTO){
        return new ResponseEntity<ResponseMemberDTO>(memberService.insertNewMember(requestMemberDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberById(@PathVariable int id){
        try {
            return new ResponseEntity<ResponseMemberDTO>(memberService.getMemberById(id), HttpStatus.OK);
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
    @GetMapping("/{id}/badges")                                             // get all badges of a member
    public ResponseEntity<?> getMemberBadges(@PathVariable int id){
        try {
            return new ResponseEntity<List<ResponseBadgeDTO>>(memberService.getMemberBadges(id), HttpStatus.OK);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/transactions")                                           // get all transactions of a member
    public ResponseEntity<?> getMemberTransactions(@PathVariable int id){
        try {
            return new ResponseEntity<List<TransactionDTO>>(memberService.getMemberTransactions(id), HttpStatus.OK);
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

    @PutMapping("/{member_id}")
    public ResponseEntity<?> updateMember(@PathVariable("member_id") int id, @RequestBody RequestMemberDTO requestMemberDTO){
            try {
                return new ResponseEntity<>(memberService.updateMember(id, requestMemberDTO), HttpStatus.OK);
            } catch (ResourceNotFoundException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
    }
    @GetMapping("/{memberid}/plans")
    public ResponseEntity<?> getPlansForMember(@PathVariable int memberid){
        return new ResponseEntity<>(membershipService.getAllPlansForMember(memberid), HttpStatus.OK);
    }


}
