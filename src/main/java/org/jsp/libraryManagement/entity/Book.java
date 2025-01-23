package org.jsp.libraryManagement.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String genre;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Loan> loans;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + "]";
	}

}
