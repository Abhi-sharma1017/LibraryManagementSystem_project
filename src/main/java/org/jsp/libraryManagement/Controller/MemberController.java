package org.jsp.libraryManagement.Controller;

import java.util.List;

import org.jsp.libraryManagement.DTO.ResponseStructure;
import org.jsp.libraryManagement.Service.MemberService;
import org.jsp.libraryManagement.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// save member
	@PostMapping
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member) {
		return memberService.saveMember(member);
	}

	// get all members
	@GetMapping("/members")
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers() {
		return memberService.getAllMembers();
	}

	// get member by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> getMemberById(@PathVariable int id) {
		return memberService.getMemberById(id);
	}

	// update member
	@PutMapping
	public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member) {
		return memberService.updateMember(member);
	}

	// delete member
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Member>> deleteMember(@PathVariable int id) {
		return memberService.deleteMember(id);
	}
}
