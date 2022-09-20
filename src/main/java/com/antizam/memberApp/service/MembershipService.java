package com.antizam.memberApp.service;

import com.antizam.memberApp.model.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipService {

    List<Membership> getAllMemberships();
    List<Membership> getMembershipsForMember(int memberId);
    void addMembership(Membership membership);
    void deleteMembership(int membershipId);
    void updateMembership(Membership membership);
    Optional<Membership> findMembershipById(int id);


}
