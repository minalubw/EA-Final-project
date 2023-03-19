package edu.miu.badge.services;

import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.MemberDTO;
import org.springframework.stereotype.Service;

public interface MemberService {
    public void insertNewMember(Member member);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);

}
