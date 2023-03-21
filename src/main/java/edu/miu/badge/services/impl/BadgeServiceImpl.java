package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import edu.miu.badge.dto.RequestBadgeDTO;
import edu.miu.badge.dto.ResponseBadgeDTO;
import edu.miu.badge.enumeration.BadgeStatus;
import java.util.Random;
import edu.miu.badge.exceptions.BadgeNotFoundException;
import edu.miu.badge.repositories.BadgeRepository;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.services.BadgeService;
import edu.miu.badge.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MemberRepository memberRepository;



    @Override
    public ResponseBadgeDTO getBadge(int id)throws BadgeNotFoundException {
        Badge badge = badgeRepository.findById(id).orElse(null);
        if (badge == null)
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        return modelMapper.map(badge, ResponseBadgeDTO.class);
    }

    @Override
    public ResponseBadgeDTO createBadge(RequestBadgeDTO badge) {                            //exception handling
        Optional<Member> member = memberRepository.findById(badge.getMemberId());
        if (!member.isPresent())
            throw new BadgeNotFoundException("Member with ID " + badge.getMemberId() + " not found");

        Badge newBadge = new Badge();
        Optional<Badge> badgeToInactivate = badgeRepository.getActiveBadge(member.get().getId());
        if(badgeToInactivate.isPresent()){
            newBadge.setBadgeStatus(BadgeStatus.ACTIVE);
            newBadge.setMember(member.get());
            newBadge.setBadgeNumber(badgeToInactivate.get().getBadgeNumber());
            badgeToInactivate.get().setBadgeStatus(BadgeStatus.INACTIVE);
            badgeRepository.save(newBadge);
            badgeRepository.save(badgeToInactivate.get());
        }
        else{
            Random random = new Random();
            newBadge.setBadgeStatus(BadgeStatus.ACTIVE);
            newBadge.setMember(member.get());
            int number = getNewBadgeNumber();
            newBadge.setBadgeNumber(number);
            badgeRepository.save(newBadge);

        }
        return modelMapper.map(newBadge, ResponseBadgeDTO.class);
    }

    @Override
    public ResponseBadgeDTO updateBadge(int id, RequestBadgeDTO badge) throws BadgeNotFoundException{
        Optional<Badge> badgeToUpdate = badgeRepository.findById(id);
        if (badgeToUpdate.isEmpty())
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        if(badge.getMemberId() != badgeToUpdate.get().getMember().getId())
            throw new BadgeNotFoundException("Member with ID " + badge.getMemberId() + " not found");
        if(badge.getBadgeStatus().equals(BadgeStatus.ACTIVE)){
            Optional<Badge> badgeToInactivate = badgeRepository.getActiveBadge(badge.getMemberId());
            List<Badge> badges = badgeRepository.findAll();
            for(Badge b: badges){
                b.setBadgeStatus(BadgeStatus.INACTIVE);
            }
            badgeRepository.saveAll(badges);
            Badge newStatus = badgeRepository.findById(id).get();
            newStatus.setBadgeStatus(BadgeStatus.ACTIVE);
            badgeRepository.save(newStatus);
            return modelMapper.map(newStatus, ResponseBadgeDTO.class);
        }
        else{
            Badge newStatus = badgeRepository.findById(id).get();
            newStatus.setBadgeStatus(BadgeStatus.INACTIVE);
            badgeRepository.save(newStatus);
            return modelMapper.map(newStatus, ResponseBadgeDTO.class);
        }
    }

    @Override
    public String inactiveBadge(int id)throws BadgeNotFoundException {
        Optional<Badge> toInactve = badgeRepository.findById(id);
        if (toInactve.isEmpty())
            throw new BadgeNotFoundException("Badge with ID " + id + " not found");
        if(toInactve.get().getBadgeStatus().equals(BadgeStatus.INACTIVE))
            throw new BadgeNotFoundException("Badge with ID " + id + " is already inactive");
        toInactve.get().setBadgeStatus(BadgeStatus.INACTIVE);
        badgeRepository.save(toInactve.get());
        return "Badge with ID " +  id+ " deactivated";
    }

    @Override
    public List<ResponseBadgeDTO> getAllBadges() {
        Optional<List<Badge>> badges = badgeRepository.getActiveBadges();
        if (badges.isEmpty())
            throw new BadgeNotFoundException("No active badges found");
        List<ResponseBadgeDTO> responseBadgeDTOS = new ArrayList<>();
        for (Badge badge : badges.get()) {
            responseBadgeDTOS.add(modelMapper.map(badge, ResponseBadgeDTO.class));
        }
        return responseBadgeDTOS;
    }
    int getNewBadgeNumber(){
        Random random = new Random();
        int number;
        do {
            number = random.nextInt(90000) + 10000;
        }while(badgeRepository.getBadgeByBadgeNumber(number).isPresent());
        return number;
    }

}
