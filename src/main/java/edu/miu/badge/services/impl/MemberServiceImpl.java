package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Role;
import edu.miu.badge.domains.Transaction;
import edu.miu.badge.dto.ResponseBadgeDTO;
import edu.miu.badge.dto.RequestMemberDTO;
import edu.miu.badge.dto.ResponseMemberDTO;
import edu.miu.badge.dto.TransactionDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.repositories.RoleRepository;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public ResponseMemberDTO insertNewMember(RequestMemberDTO requestMemberDTO) {
        List<Role> role = new ArrayList<>();
        for(Integer roleId: requestMemberDTO.getRoles()){
            Optional<Role> role1 = roleRepository.findById(roleId);
            if(role1.isPresent()){
                role.add(role1.get());
            }else{
                throw new ResourceNotFoundException("Role with id " + roleId + " not found");
            }
        }
        Member member = modelMapper.map(requestMemberDTO, Member.class);
        member.setRoles(role);
        return modelMapper.map(memberRepository.save(member), ResponseMemberDTO.class);
    }

    @Override
    public ResponseMemberDTO getMemberById(int id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return modelMapper.map(member.get(), ResponseMemberDTO.class);
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
    public List<ResponseBadgeDTO> getMemberBadges(int id) {
        List<Badge> badges = memberRepository.allBadgesOfMember(id);
        List<ResponseBadgeDTO> responseBadgeDTOS = new ArrayList<>();
        for(Badge badge: badges){
            responseBadgeDTOS.add(modelMapper.map(badge, ResponseBadgeDTO.class));
        }
        return responseBadgeDTOS;
    }

    @Override
    public List<TransactionDTO> getMemberTransactions(int id) {
        List<Transaction> transactions = memberRepository.allTransactionsOfMember(id);
        List<TransactionDTO> transactionDTOs= new ArrayList<>();
        for(Transaction transaction: transactions){
            transactionDTOs.add(modelMapper.map(transaction, TransactionDTO.class));
        }
        return transactionDTOs;
    }
    @Override
    public ResponseMemberDTO updateMember(int id, RequestMemberDTO requestMemberDTO) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if(memberOptional.isPresent()){
            Member toBeUpdated = memberOptional.get();
            toBeUpdated.setFirstName(requestMemberDTO.getFirstName());
            toBeUpdated.setLastName(requestMemberDTO.getLastName());
            toBeUpdated.setEmail(requestMemberDTO.getEmail());
            return modelMapper.map(memberRepository.save(toBeUpdated), ResponseMemberDTO.class);
        }else {
            throw new ResourceNotFoundException("Member with id " + id + " doesn't exists");
        }
    }
    @Override
    public List<ResponseMemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> modelMapper.map(member, ResponseMemberDTO.class))
                .collect(Collectors.toList());
    }


}
