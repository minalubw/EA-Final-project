package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void insertNewMember(MemberDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        memberRepository.save(member);
    }

    @Override
    public List<MemberDTO> getMembers() {
        return memberRepository
                .findAll()
                .stream()
                .map(member -> modelMapper.map(member, MemberDTO.class))
                .collect(Collectors.toList());
    }
}
