package edu.miu.badge.services;


public interface MembershipService {
    public Membership getOneMembershipById(int membershipId);
    public Collection<Membership> getAll();
    public Membership create(Membership membership);
    public Membership update(Membership membership);
    public void delete(int membershipId);
}
