package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void insertNewMember(MemberDTO memberDTO) {
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    @Override
    public MemberDTO getMemberById(int id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return modelMapper.map(member.get(), MemberDTO.class);
        }
        throw new MemberNotFoundException("Member with id " + id + " not found");
    }

    @Override
    public String deleteMemberById(int id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            memberRepository.delete(member.get());
            return "Member with id " + id + " deleted successfully";
        }
        throw new MemberNotFoundException("Member with id " + id + " not found");
    }
}
