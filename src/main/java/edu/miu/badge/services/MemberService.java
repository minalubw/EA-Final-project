package edu.miu.badge.services;

import edu.miu.badge.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    public MemberDTO insertNewMember(MemberDTO memberDTO);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);
    List<MemberDTO> getAllMembers();
    MemberDTO updateMember(int id, MemberDTO memberDTO);

}
