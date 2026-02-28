package com.capgemini.LibraryManagement.controller;

import java.util.*;
import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.*;
import com.capgemini.LibraryManagement.service.impl.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMember();
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
                               @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteOrDisableMember(id);
    }
}