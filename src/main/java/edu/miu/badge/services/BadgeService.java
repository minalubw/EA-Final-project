package edu.miu.badge.services;

import edu.miu.badge.dto.ResponseBadgeDTO;

import java.util.List;

public interface BadgeService {
    ResponseBadgeDTO getBadge(int id);
    ResponseBadgeDTO createBadge(ResponseBadgeDTO badge);
    ResponseBadgeDTO updateBadge(int id, ResponseBadgeDTO badge);
    String inactiveBadge(int id);
    List<ResponseBadgeDTO> getAllBadges();
}
