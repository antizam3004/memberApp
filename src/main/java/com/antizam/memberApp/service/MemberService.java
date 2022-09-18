package com.antizam.memberApp.service;

import com.antizam.memberApp.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();
    void addMember(Member member);
}
