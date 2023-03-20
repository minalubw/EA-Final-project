package edu.miu.badge.services;

import edu.miu.badge.domains.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
    public MemberDTO insertNewMember(MemberDTO memberDTO);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);
    List<MemberDTO> getAllMembers();
    MemberDTO updateMember(int id, MemberDTO memberDTO);

}
