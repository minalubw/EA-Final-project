package edu.miu.badge.services.impl;

import edu.miu.badge.domains.MemberShip;
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
    public MemberShip getOneMembershipById(int membershipId) {
        return membershipRepository.findById(membershipId).get();
    }
}
