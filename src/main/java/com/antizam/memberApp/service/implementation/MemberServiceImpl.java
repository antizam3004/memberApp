package com.antizam.memberApp.service.implementation;

import com.antizam.memberApp.model.Member;
import com.antizam.memberApp.repository.MemberRepository;
import com.antizam.memberApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void addMember(Member member) {
        memberRepository.save(member);}

    @Override
    public Optional<Member> findMember(int id) {
        return memberRepository.findById(id);
    }

}
