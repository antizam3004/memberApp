package com.antizam.memberApp.service;

import com.antizam.memberApp.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<Member> getAllMembers();
    void addMember(Member member);
    Optional<Member> findMember(int id);
}
