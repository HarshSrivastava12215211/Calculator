package com.capgemini.LibraryManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.LibraryManagement.dto.Member;
import java.util.*;
public interface MemberDAO extends JpaRepository<Member, Long> {

	List<Member> findByStatus(String statu);
	Member findByEmail(String email);
}
