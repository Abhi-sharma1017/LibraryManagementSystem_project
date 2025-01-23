package org.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.Repository.LoanRepository;
import org.jsp.libraryManagement.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoanDao {

	@Autowired
	private LoanRepository loanRepository;

	// Save loan
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	// Get all loans
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	// Get loan by id
	public Optional<Loan> getLoanById(int id) {
		return loanRepository.findById(id);
	}

	// Update loan
	public Loan updateLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	// Delete loan
	public void deleteLoan(Loan loan) {
		loanRepository.delete(loan);
	}

}
