package edu.miu.badge.services;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.dto.BadgeDTO;
import edu.miu.badge.dto.MemberDTO;
import edu.miu.badge.dto.TransactionDTO;

import java.util.List;

public interface MemberService {
    public void insertNewMember(MemberDTO memberDTO);
    public MemberDTO getMemberById(int id);
    public String deleteMemberById(int id);
    public List<BadgeDTO> getMemberBadges(int id);
    public List<TransactionDTO> getMemberTransactions(int id);

}
