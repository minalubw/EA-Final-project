package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Membership1;
import edu.miu.badge.repositories.MembershipRepository;
import edu.miu.badge.services.MembershipService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepository;
    public Collection<Membership1> getAll(){
        return membershipRepository.findAll();
    }
    public Membership1 getById(int membershipId){
        return membershipRepository.findById(membershipId).get();
    }
    public void create(Membership1 membership){
        membershipRepository.save(membership);
    }
    public void update(int membershipId, Membership1 membership){
        membershipRepository.save(membership);
    }
    public void delete(int membershipId){
        membershipRepository.deleteById(membershipId);
    }
}
