package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Member;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Override
    public void insertNewMember(Member member) {
        memberRepository.save(member);
    }
}
