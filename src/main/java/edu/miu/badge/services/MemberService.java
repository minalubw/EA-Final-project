package edu.miu.badge.services;

import edu.miu.badge.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    public void insertNewMember(MemberDTO memberDTO);
    public List<MemberDTO> getMembers();
}
