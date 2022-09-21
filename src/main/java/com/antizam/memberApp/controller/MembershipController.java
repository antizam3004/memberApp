package com.antizam.memberApp.controller;

import com.antizam.memberApp.model.Member;
import com.antizam.memberApp.model.Membership;
import com.antizam.memberApp.service.MemberService;
import com.antizam.memberApp.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class MembershipController {

    MemberService memberService;
    MembershipService membershipService;

    @Autowired
    public MembershipController(MemberService memberService, MembershipService membershipService) {
        this.memberService = memberService;
        this.membershipService = membershipService;
    }

    @GetMapping("/membershipForm/{member_id}")
    public String viewMemberships(Model model, @PathVariable("member_id") int member_id) {
        model.addAttribute("membershipList", membershipService.getMembershipsForMember(member_id));
        model.addAttribute("member_id", member_id);
        return "memberships";
    }

    @GetMapping("/addNewMembershipForm/{member_id}")
    public String addNewMembership(Model model, @PathVariable("member_id") int member_id) {
        Membership membership = new Membership();
        Optional<Member> member = memberService.findMemberById(member_id);
        member.ifPresent(member1 -> {
            membership.setMember(member1);
        });
        model.addAttribute("membership", membership);
        return "add_new_membership";
    }

    @PostMapping("/addMembership")
    public String addMembership(@ModelAttribute @Valid Membership membership, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return "add_new_membership";
        }
        membershipService.addMembership(membership);
        return "redirect:/members";
    }

    @GetMapping("/deleteMembership/{id}")
    public String deleteMembership(@PathVariable("id") int id) {
        membershipService.deleteMembership(id);
        return "redirect:/members";
    }
    @GetMapping("/changeMembershipForm/{id}")
    public String changeMembershipForm(Model model, @PathVariable("id") int id){
        model.addAttribute("membership", membershipService.findMembershipById(id));
        return "change_membership";
    }
    @PostMapping("/updateMembership")
    public String updateUser(@Valid Membership membership, BindingResult result) {
        System.out.println(membership.getAmount());
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors().toString());
            return "change_membership";
        }
        membershipService.updateMembership(membership);
        return "redirect:/members";
    }

}
