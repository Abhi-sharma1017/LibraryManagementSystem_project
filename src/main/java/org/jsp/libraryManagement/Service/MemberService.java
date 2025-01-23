package org.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.DAO.MemberDao;
import org.jsp.libraryManagement.DTO.ResponseStructure;
import org.jsp.libraryManagement.Exception.IdNotFoundException;
import org.jsp.libraryManagement.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;

	// save member
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member) {
		Member recievedMember = memberDao.saveMember(member);

		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedMember);
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.CREATED);
	}

	// get all members
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers() {
		List<Member> listOfMembers = memberDao.getAllMembers();

		ResponseStructure<List<Member>> structure = new ResponseStructure<List<Member>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(listOfMembers);
		return new ResponseEntity<ResponseStructure<List<Member>>>(structure, HttpStatus.OK);
	}

	// get member by id
	public ResponseEntity<ResponseStructure<Member>> getMemberById(int id) {
		Optional<Member> opt = memberDao.getMemberById(id);
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if (opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	// update member
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member) {
		Member updatedMember = memberDao.updateMember(member);

		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updatedMember);
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
	}

	// delete member
	public ResponseEntity<ResponseStructure<Member>> deleteMember(int id) {
		Optional<Member> opt = memberDao.getMemberById(id);

		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if (opt.isPresent()) {
			Member member = opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			memberDao.deleteMember(member);
			return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

}
