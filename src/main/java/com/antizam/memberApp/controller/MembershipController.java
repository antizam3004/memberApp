package com.antizam.memberApp.controller;

import com.antizam.memberApp.model.Member;
import com.antizam.memberApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MembershipController {

    MemberService memberService;

    @Autowired
    public MembershipController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/membershipForm/{member_id}")
    public String addMemberForm(Model model, @PathVariable("member_id") int member_id) {
        Optional<Member> member =memberService.findMember(member_id);


        model.addAttribute("membership", membership);
        return "memberships";
    }
}
