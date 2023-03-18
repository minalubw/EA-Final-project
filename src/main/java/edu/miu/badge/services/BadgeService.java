package edu.miu.badge.services;

import edu.miu.badge.domains.Badge;

import java.util.Collection;

public interface BadgeService {
    Badge getBadge(int id);
    Badge createBadge(Badge badge);
    Badge updateBadge(int id, Badge badge);
    String inactiveBadge(int id);
    Collection<Badge> getAllBadges();
}
