package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.BadgeDTO;
import edu.miu.badge.exceptions.BadgeNotFoundException;
import edu.miu.badge.repositories.BadgeRepository;
import edu.miu.badge.services.BadgeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public BadgeDTO getBadge(int id)throws BadgeNotFoundException {
        Badge badge = badgeRepository.findById(id).orElse(null);
        if (badge == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        return modelMapper.map(badge, BadgeDTO.class);
    }

    @Override
    public BadgeDTO createBadge(BadgeDTO badge) {                            //exception handling
        Badge badgeToSave = modelMapper.map(badge, Badge.class);
        return modelMapper.map(badgeRepository.save(badgeToSave), BadgeDTO.class);
    }

    @Override
    public BadgeDTO updateBadge(int id,BadgeDTO badge) throws BadgeNotFoundException{
        Badge badgeToUpdate = badgeRepository.findById(id).orElse(null);
        if (badgeToUpdate == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        badgeToUpdate.setActive(badge.isActive());
        badgeToUpdate.setMember(badge.getMember());
        return modelMapper.map(badgeRepository.save(badgeToUpdate), BadgeDTO.class);
    }

    @Override
    public String inactiveBadge(int id)throws BadgeNotFoundException {
        Badge toInactve = badgeRepository.findById(id).orElse(null);
        if (toInactve == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        toInactve.setActive(false);
        badgeRepository.save(toInactve);
        return "Badge with ID " +  id+ " deactivated";
    }

    @Override
    public List<BadgeDTO> getAllBadges() {
        List<Badge> badges = badgeRepository.findAll();
        List<BadgeDTO> badgeDTOS = new ArrayList<>();
        for (Badge badge : badges) {
            badgeDTOS.add(modelMapper.map(badge, BadgeDTO.class));
        }
        return badgeDTOS;
    }


}
