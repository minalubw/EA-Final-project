package edu.miu.badge.services;

import edu.miu.badge.domains.Membership1;

import java.util.Collection;

public interface MembershipService {
    public Collection<Membership1> getAll();
    public Membership1 getById(int membershipId);
    public void create(Membership1 membership);
    public void update(int membershipId, Membership1 membership);
    public void delete(int membershipId);
}
