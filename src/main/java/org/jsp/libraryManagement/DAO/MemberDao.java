package org.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.Repository.MemberRepository;
import org.jsp.libraryManagement.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	private MemberRepository memberRepository;

	// Save member
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	// Get all members
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	// Get member by id
	public Optional<Member> getMemberById(int id) {
		return memberRepository.findById(id);
	}

	// Update member
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}

	// Delete member
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}

}
