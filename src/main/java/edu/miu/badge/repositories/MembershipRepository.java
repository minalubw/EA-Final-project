package edu.miu.badge.repositories;

import edu.miu.badge.domains.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<MemberShip, Integer> {
}
