package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Membership;
import edu.miu.badge.domains.Transaction;
import edu.miu.badge.dto.BadgeDTO;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.dto.MembershipDTO;
import edu.miu.badge.dto.TransactionDTO;
import edu.miu.badge.exceptions.MemberNotFoundException;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    @Override
    public List<BadgeDTO> getMemberBadges(int id) {
        List<Badge> badges = memberRepository.allBadgesOfMember(id);
        List<BadgeDTO> badgeDTOs= new ArrayList<>();
        for(Badge badge: badges){
            badgeDTOs.add(modelMapper.map(badge, BadgeDTO.class));
        }
        return badgeDTOs;
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
    public List<MembershipDTO> getAllMembershipOfMember(int memberId) {
        List<MembershipDTO> membershipDTOS = new ArrayList<MembershipDTO>();
        List<Membership> memberships = memberRepository.allMembershipsOfMember(memberId);
        for (Membership p: memberships) {
            membershipDTOS.add(modelMapper.map(p, MembershipDTO.class));
        }
        return membershipDTOS;
    }
}
