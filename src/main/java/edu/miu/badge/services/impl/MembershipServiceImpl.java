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
}
