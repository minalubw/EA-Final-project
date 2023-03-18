package edu.miu.badge.repositories;

import edu.miu.badge.domains.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
}
