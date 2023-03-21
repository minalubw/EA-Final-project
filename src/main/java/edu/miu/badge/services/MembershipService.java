package edu.miu.badge.services;


import edu.miu.badge.dto.RequestMemberDTO;
import edu.miu.badge.dto.RequestMembershipDTO;
import edu.miu.badge.dto.ResponseMembershipDTO;
import edu.miu.badge.dto.PlanDTO;

import java.util.List;

public interface MembershipService {
    public ResponseMembershipDTO getMembershipById(int membershipId);
    public List<ResponseMembershipDTO> getAll();
    public ResponseMembershipDTO create(RequestMembershipDTO membershipDTO);
    public ResponseMembershipDTO update(int membershipId, RequestMembershipDTO membershipDTO);
    public String delete(int membershipId);
    public List<ResponseMembershipDTO> getMembershipsByMemberId(int memberId, String planType);
    public List<PlanDTO> getAllPlansForMember(int memberId);

}
