package edu.miu.badge.services;


import edu.miu.badge.dto.MembershipDTO;

import java.util.List;

public interface MembershipService {
    public MembershipDTO getMembershipById(int membershipId);
    public List<MembershipDTO> getAll();
    public MembershipDTO create(MembershipDTO membershipDTO);
    public MembershipDTO update(int membershipId, MembershipDTO membershipDTO);
    public String delete(int membershipId);
    List<MembershipDTO> getAllMembershipOfMember(int memberId);

}
