package com.antizam.memberApp.controller;

import com.antizam.memberApp.model.Member;
import com.antizam.memberApp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String getAllMembers(Model model) {
        model.addAttribute("membersList", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/addMemberForm")
    public String addMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "add_new_member";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute @Valid Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add_new_member";
        }
        memberService.addMember(member);
        return "redirect:/members";
    }


}
