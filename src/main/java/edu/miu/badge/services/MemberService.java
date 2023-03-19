package edu.miu.badge.services;

import edu.miu.badge.dto.MemberDTO;

public interface MemberService {
    public void insertNewMember(MemberDTO memberDTO);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);

}
