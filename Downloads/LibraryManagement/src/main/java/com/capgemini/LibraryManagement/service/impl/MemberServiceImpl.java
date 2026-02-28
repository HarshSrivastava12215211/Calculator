package com.capgemini.LibraryManagement.service.impl;
import com.capgemini.LibraryManagement.dao.MemberDAO;
import com.capgemini.LibraryManagement.dto.Member;
import com.capgemini.LibraryManagement.service.*;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private  MemberDAO memberRepository;

    @Override
    @Transactional
    public Member addMember(Member member) {

        member.setMemberSice(LocalDate.now());
        member.setStatus("ACTIVE");

        return memberRepository.save(member);
    }
    
    @Override
    @Transactional
    public Member getMemberById(Long memberId) {

        Member member = memberRepository.findById(memberId).orElse(null);
        return member;
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional
    public Member updateMember(Long memberId, Member updatedMember) {

        Member existing = getMemberById(memberId);

        existing.setName(updatedMember.getName());
        existing.setEmail(updatedMember.getEmail());
        existing.setPhone(updatedMember.getPhone());

        return memberRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteOrDisableMember(Long memberId) {

        Member member = getMemberById(memberId);
        member.setStatus("BLOCKED");

        memberRepository.save(member);
    }
}
