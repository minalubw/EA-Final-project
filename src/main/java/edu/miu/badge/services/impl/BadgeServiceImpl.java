package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.exceptions.BadgeNotFoundException;
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
    public Badge getBadge(int id)throws BadgeNotFoundException {
        Badge badge = badgeRepository.findById(id).orElse(null);
        if (badge == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        return badge;
    }

    @Override
    public Badge createBadge(Badge badge) {                            //exception handling
        return badgeRepository.save(badge);
    }

    @Override
    public Badge updateBadge(int id,Badge badge) throws BadgeNotFoundException{
        Badge badgeToUpdate = badgeRepository.findById(id).orElse(null);
        if (badgeToUpdate == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        badgeToUpdate.setActive(badge.isActive());
        badgeToUpdate.setMember(badge.getMember());
        return badgeRepository.save(badgeToUpdate);
    }

    @Override
    public String inactiveBadge(int id)throws BadgeNotFoundException {
        Badge toInactve = badgeRepository.findById(id).orElse(null);
        if (toInactve == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        toInactve.setActive(false);
        return "Badge with ID " +  id+ " deactivated";
    }

    @Override
    public Collection<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }


}
