package com.capgemini.LibraryManagement.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;
@Entity
public class Member {
	
	@Id
	private int memberId;
	private String name;
	private String email;
	private String phone;
	private LocalDate memberSice;
	private String status;
	
	@OneToMany(mappedBy = "member")
	private List<Loan> loans;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getMemberSice() {
		return memberSice;
	}

	public void setMemberSice(LocalDate memberSice) {
		this.memberSice = memberSice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", memberSice=" + memberSice + ", status=" + status + ", loans=" + loans + "]";
	}
	
	
}
