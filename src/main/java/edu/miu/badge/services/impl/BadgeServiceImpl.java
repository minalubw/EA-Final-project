package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.repositories.BadgeRepository;
import edu.miu.badge.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    BadgeRepository badgeRepository;


    @Override
    public Badge getBadge(int id) {
        return badgeRepository.findById(id).get();
    }

    @Override
    public Badge addBadge(Badge badge) {                            //exception handling
        return badgeRepository.save(badge);
    }

    @Override
    public Badge updateBadge(int id,Badge badge) {
        Badge badgeToUpdate = badgeRepository.findById(id).get();
        badgeToUpdate.setActive(badge.isActive());
        badgeToUpdate.setMember(badge.getMember());
        return badgeRepository.save(badgeToUpdate);
    }

    @Override
    public String inactiveBadge(int id) {
        Badge toInactve = badgeRepository.findById(id).get();
        toInactve.setActive(false);
        return "Badge with ID " +  id+ " deactivated";
    }

    @Override
    public Collection<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }


}
