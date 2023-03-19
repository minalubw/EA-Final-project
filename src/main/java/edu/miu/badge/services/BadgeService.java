package edu.miu.badge.services;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.dto.BadgeDTO;

import java.util.Collection;
import java.util.List;

public interface BadgeService {
    BadgeDTO getBadge(int id);
    BadgeDTO createBadge(BadgeDTO badge);
    BadgeDTO updateBadge(int id, BadgeDTO badge);
    String inactiveBadge(int id);
    List<BadgeDTO> getAllBadges();
}
