package org.jsp.libraryManagement.Repository;

import org.jsp.libraryManagement.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
