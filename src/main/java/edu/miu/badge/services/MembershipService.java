package edu.miu.badge.services;


import edu.miu.badge.domains.Membership;

import java.util.Collection;

public interface MembershipService {
    public Membership getOneMembershipById(int membershipId);
}
