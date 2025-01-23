package org.jsp.libraryManagement.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phone;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)

	// to ignore loans details in book
	@JsonIgnore
	private List<Loan> loans;

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

}
