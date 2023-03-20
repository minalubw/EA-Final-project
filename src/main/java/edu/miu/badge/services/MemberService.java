package edu.miu.badge.services;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.dto.BadgeDTO;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.dto.MembershipDTO;
import edu.miu.badge.dto.TransactionDTO;

import java.util.List;

import java.util.List;

public interface MemberService {
    public MemberDTO insertNewMember(MemberDTO memberDTO);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);
    List<MemberDTO> getAllMembers();
    MemberDTO updateMember(int id, MemberDTO memberDTO);
    List<BadgeDTO> getMemberBadges(int id);
    List<TransactionDTO> getMemberTransactions(int id);

}
