package com.antizam.memberApp.service.implementation;

import com.antizam.memberApp.controller.MembershipController;
import com.antizam.memberApp.model.Membership;
import com.antizam.memberApp.repository.MembershipRepository;
import com.antizam.memberApp.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MembershipServiceImpl implements MembershipService {

    MembershipRepository membershipRepository;

    @Autowired
    public MembershipServiceImpl(MembershipRepository membershipRepository){
        this.membershipRepository=membershipRepository;
    }
    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public List<Membership> getMembershipsForMember(int memberId) {
       return membershipRepository.findAll().stream().filter(membership -> membership.getMember().getId()==memberId).collect(Collectors.toList());
    }

    @Override
    public void addMembership(Membership membership) {
        membershipRepository.save(membership);
    }

    @Override
    public void deleteMembership(int membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    @Override
    public void updateMembership(Membership membership) {
        membershipRepository.membershipUpdate(membership.getId(),
                membership.getAmount(),
                membership.getDescription(),
                membership.getDatePaid(),
                membership.isPaid());
    }

    public Optional<Membership> findMembershipById(int id){
        return membershipRepository.findById(id);
    }

}
