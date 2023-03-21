package edu.miu.badge.services.impl;

import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Membership;
import edu.miu.badge.domains.Plan;
import edu.miu.badge.domains.PlanType;
import edu.miu.badge.dto.RequestMembershipDTO;
import edu.miu.badge.dto.ResponseMembershipDTO;
import edu.miu.badge.dto.PlanDTO;
import edu.miu.badge.exceptions.ResourceNotFoundException;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.repositories.MembershipRepository;
import edu.miu.badge.repositories.PlanRepository;
import edu.miu.badge.services.MembershipService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PlanRepository planRepository;

    @Autowired
    ModelMapper modelMapper;
    public ResponseMembershipDTO getMembershipById(int membershipId){
        Membership membership = membershipRepository.findById(membershipId).orElse(null);
        if(membership == null) throw new ResourceNotFoundException("Membership with an id " + membershipId + " not found");
        return modelMapper.map(membership, ResponseMembershipDTO.class);
    }

    public List<ResponseMembershipDTO> getAll(){
        return membershipRepository.findAll().stream()
                .map(membership -> modelMapper.map(membership, ResponseMembershipDTO.class))
                .collect(Collectors.toList());
    }

    public ResponseMembershipDTO create(RequestMembershipDTO membershipDTO){
        Optional<Member> member = memberRepository.findById(membershipDTO.getMember_id());
        if (!member.isPresent())
            throw new ResourceNotFoundException("Member with ID " + membershipDTO.getMember_id() + " not found");
        Optional<Plan> plan = planRepository.findById(membershipDTO.getPlan_id());
        if (!plan.isPresent())
            throw new ResourceNotFoundException("Plan with ID " + membershipDTO.getPlan_id() + " not found");
        //check plan type
        Boolean validPlanTypePresent = false;
        for(PlanType pt: plan.get().getPlanTypes()){
            if(pt.getId() == membershipDTO.getPlanType_id()){
                validPlanTypePresent = true;
            }
        }
        if (!validPlanTypePresent) throw new ResourceNotFoundException("Plan Type with ID " + membershipDTO.getPlanType_id() + " not valid");
        //PlanType planType = planTypeRepository.findById(membershipDTO.getPlanType_id())
        Membership membership = new Membership();
        membership.setStartDate(membershipDTO.getStartDate());
        membership.setEndDate(membershipDTO.getEndDate());
        membership.setMember(member.get());
        membership.setPlan(plan.get());
//      membership.setPlanType(planType);
        membership.setNumberOfAllowance(membershipDTO.getNumberOfAllowance());
        return modelMapper.map(membershipRepository.save(membership), ResponseMembershipDTO.class);
    }

    public ResponseMembershipDTO update(int membershipId, RequestMembershipDTO membershipDTO){
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            Optional<Member> member = memberRepository.findById(membershipDTO.getMember_id());
            if (!member.isPresent())
                throw new ResourceNotFoundException("Member with ID " + membershipDTO.getMember_id() + " not found");
            Optional<Plan> plan = planRepository.findById(membershipDTO.getPlan_id());
            if (!plan.isPresent())
                throw new ResourceNotFoundException("Plan with ID " + membershipDTO.getPlan_id() + " not found");
            //check plan type
            Boolean validPlanTypePresent = false;
            for(PlanType pt: plan.get().getPlanTypes()){
                if(pt.getId() == membershipDTO.getPlanType_id()){
                    validPlanTypePresent = true;
                }
            }
            if (!validPlanTypePresent) throw new ResourceNotFoundException("Plan Type with ID " + membershipDTO.getPlanType_id() + " not valid");
            //PlanType planType = planTypeRepository.findById(membershipDTO.getPlanType_id())
            Membership toBeUpdated = membershipOptional.get();
            toBeUpdated.setStartDate(membershipDTO.getStartDate());
            toBeUpdated.setEndDate(membershipDTO.getEndDate());
            toBeUpdated.setMember(member.get());
            toBeUpdated.setPlan(plan.get());
//          toBeUpdated.setPlanType(planType);
            toBeUpdated.setNumberOfAllowance(membershipDTO.getNumberOfAllowance());
            return modelMapper.map(membershipRepository.save(toBeUpdated), ResponseMembershipDTO.class);
        }
        else{
            throw new ResourceNotFoundException("Membership with an id " + membershipDTO + " doesn't exist");
        }
    }

    public String delete(int membershipId){
        Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
        if(membershipOptional.isPresent()){
            membershipRepository.delete(membershipOptional.get());
            return "Membership with id " + membershipId + " deleted!";
        }
        else{
            throw new ResourceNotFoundException("Membership with an id " + membershipId + " doesn't exist");
        }
    }

    public List<ResponseMembershipDTO> getMembershipsByMemberId(int memberId, String planType){
        List<ResponseMembershipDTO> list =  membershipRepository.findMembershipsByMemberId(memberId).stream()
                .map(membership -> modelMapper.map(membership, ResponseMembershipDTO.class))
                .collect(Collectors.toList());
        if(planType.isEmpty()) {
            return list;
        }
        else{
            return list.stream().filter(l -> l.getPlanType().getPlanType().equals(planType)).collect(Collectors.toList());
        }
    }

    @Override
    public List<PlanDTO> getAllPlansForMember(int memberId) {
        return membershipRepository.findPlansByMemberId(memberId).stream()
                .map(p -> modelMapper.map(p, PlanDTO.class)).collect(Collectors.toList());
    }

}
