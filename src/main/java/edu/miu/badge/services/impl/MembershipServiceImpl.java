package edu.miu.badge.services.impl;

import edu.miu.badge.repositories.MembershipRepository;
import edu.miu.badge.services.MembershipService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepository;
    public Membership getOneMembershipById(int membershipId) {
        return membershipRepository.findById(membershipId).get();
    }
    public Collection<Membership> getAll(){
        return membershipRepository.findAll();
    }

    public Membership create(Membership membership){
        Membership membership1 = membershipRepository.save(membership);
        return  membership1;
    }
    public Membership update(Membership membership){
        Membership membership1 = membershipRepository.save(membership);
        return  membership1;
    }
    public void delete(int membershipId){
        membershipRepository.deleteById(membershipId);
    }
}
