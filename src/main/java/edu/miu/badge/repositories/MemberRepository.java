package edu.miu.badge.repositories;


import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
        @Query("select b from Member m join m.badges b where m.id = ?1 and b.badgeStatus = 'ACTIVE'")
        Badge activeBadgeOfMember(int memberId);
}
