package org.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.DAO.BookDao;
import org.jsp.libraryManagement.DAO.LoanDao;
import org.jsp.libraryManagement.DAO.MemberDao;
import org.jsp.libraryManagement.DTO.ResponseStructure;
import org.jsp.libraryManagement.Exception.IdNotFoundException;
import org.jsp.libraryManagement.entity.Book;
import org.jsp.libraryManagement.entity.Loan;
import org.jsp.libraryManagement.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	@Autowired
	LoanDao loanDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	MemberDao memberDao;

	// save loan
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan) {
		Optional<Book> book = bookDao.getBookById(loan.getBook().getId());
		Optional<Member> member = memberDao.getMemberById(loan.getMember().getId());

		if (book.isPresent() && member.isPresent()) {
			Loan recievedLoan = loanDao.saveLoan(loan);
			recievedLoan.setBook(book.get());
			recievedLoan.setMember(member.get());
			ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(recievedLoan);
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException();
		}

	}

	// get all loans
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoans() {
		List<Loan> listOfLoans = loanDao.getAllLoans();

		ResponseStructure<List<Loan>> structure = new ResponseStructure<List<Loan>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(listOfLoans);
		return new ResponseEntity<ResponseStructure<List<Loan>>>(structure, HttpStatus.OK);
	}

	// get loan by id
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(int id) {
		Optional<Loan> opt = loanDao.getLoanById(id);

		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if (opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	// update loan
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan) {
		Loan updatedLoan = loanDao.updateLoan(loan);

		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updatedLoan);
		return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
	}

	//delete loan
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(int id) {
		Optional<Loan> opt = loanDao.getLoanById(id);

		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if (opt.isPresent()) {
			Loan loan = opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			loanDao.deleteLoan(loan); // opt.get()
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

}
