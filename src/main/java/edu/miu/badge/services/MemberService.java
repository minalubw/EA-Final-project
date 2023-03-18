package edu.miu.badge.services;

import edu.miu.badge.domains.Member;
import org.springframework.stereotype.Service;

public interface MemberService {
    public void insertNewMember(Member member);
}
