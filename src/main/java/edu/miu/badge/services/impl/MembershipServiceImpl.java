package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Membership;
import edu.miu.badge.dto.MembershipDTO;
import edu.miu.badge.exceptions.MembershipNotFoundException;
import edu.miu.badge.repositories.MembershipRepository;
import edu.miu.badge.services.MembershipService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    ModelMapper modelMapper;

    public MembershipDTO getMembershipById(int membershipId){
        Membership membership = membershipRepository.findById(membershipId).orElse(null);
        if(membership == null) throw new MembershipNotFoundException("Membership with an id " + membershipId + " not found");
        return modelMapper.map(membership, MembershipDTO.class);
    }
    public List<MembershipDTO> getAll(){
        List<MembershipDTO> membershipDTOS = new ArrayList<MembershipDTO>();
        for (Membership p: membershipRepository.findAll()) {
            membershipDTOS.add(modelMapper.map(p, MembershipDTO.class));
        }
        return membershipDTOS;
    }
    public MembershipDTO create(MembershipDTO membershipDTO){
        return modelMapper.map(membershipRepository.save(modelMapper.map(membershipDTO, Membership.class)), MembershipDTO.class);
    }
    public MembershipDTO update(int membershipId, MembershipDTO membershipDTO){
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            Membership toBeUpdated = membershipOptional.get();
            toBeUpdated.setStartDate(membershipDTO.getStartDate());
            toBeUpdated.setEndDate(membershipDTO.getEndDate());
            toBeUpdated.setMember(membershipDTO.getMember());
            toBeUpdated.setPlan(membershipDTO.getPlan());
            toBeUpdated.setPlanType(membershipDTO.getPlanType());
            toBeUpdated.setNumberOfAllowance(membershipDTO.getNumberOfAllowance());
            return modelMapper.map(membershipRepository.save(toBeUpdated), MembershipDTO.class);
        }
        else{
            throw new MembershipNotFoundException("Membership with an id " + membershipDTO + " doesn't exist");
        }
    }
    public String delete(int membershipId){
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            membershipRepository.delete(membershipOptional.get());
            return "Membership with id " + membershipId + " deleted!";
        }
        else{
            throw new MembershipNotFoundException("Membership with an id " + membershipId + " doesn't exist");
        }
    }

}
