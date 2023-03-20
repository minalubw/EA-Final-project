package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public MemberDTO insertNewMember(MemberDTO memberDTO) {
        return modelMapper.map(memberRepository.save(modelMapper.map(memberDTO, Member.class)), MemberDTO.class);
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
    @Override
    public MemberDTO updateMember(int id, MemberDTO memberDTO) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if(memberOptional.isPresent()){
            Member toBeUpdated = memberOptional.get();
            toBeUpdated.setFirstName(memberDTO.getFirstName());
            toBeUpdated.setLastName(memberDTO.getLastName());
            toBeUpdated.setEmail(memberDTO.getEmail());
            toBeUpdated.setRoles(memberDTO.getRoles());
            toBeUpdated.setBadges(memberDTO.getBadges());
            toBeUpdated.setMemberships(memberDTO.getMemberships());
            return modelMapper.map(memberRepository.save(toBeUpdated), MemberDTO.class);
        }else {
            throw new ResourceNotFoundException("Member with id " + id + " doesn't exists");
        }
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> modelMapper.map(member, MemberDTO.class))
                .collect(Collectors.toList());
    }
}
