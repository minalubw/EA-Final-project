package edu.miu.badge.services;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.dto.BadgeDTO;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.dto.MembershipDTO;
import edu.miu.badge.dto.TransactionDTO;

import java.util.List;

public interface MemberService {
    void insertNewMember(MemberDTO memberDTO);
     MemberDTO getMemberById(int id);
     String deleteMemberById(int id);
     List<BadgeDTO> getMemberBadges(int id);
     List<TransactionDTO> getMemberTransactions(int id);

}
