package edu.miu.badge.repositories;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.exceptions.BadgeNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
    @Query("SELECT b FROM Badge b WHERE b.member.id = ?1 AND b.badgeStatus = 'ACTIVE'")
    Optional<Badge> getActiveBadge(int memberId);

    @Query("SELECT b FROM Badge b WHERE b.badgeStatus = 'ACTIVE'")
    Optional<List<Badge>> getActiveBadges();

    @Query("SELECT b FROM Badge b WHERE b.badgeNumber = ?1")
    Optional<Badge> getBadgeByBadgeNumber( int badgeNumber);




}
