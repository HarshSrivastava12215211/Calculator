package com.capgemini.LibraryManagement.service;
import com.capgemini.LibraryManagement.dto.*;
import java.util.*;
public interface MemberService {
	
	Member addMember(Member member);
	//Member getMemberById( long memberId);
	
	List<Member> getAllMember();
	
	Member updateMember(Long memberId, Member UpdateMember);
	
	void deleteOrDisableMember(Long memberId);
	Member getMemberById(Long memberId);
}
