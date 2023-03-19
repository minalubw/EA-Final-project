package edu.miu.badge.repositories;

import edu.miu.badge.domains.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    @Query("select ms from Membership ms where ms.member.id = :member_id")
    List<Membership> findMembershipsByMemberId(@Param("member_id") int member_id);
}
