package org.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.Repository.AuthorRepository;
import org.jsp.libraryManagement.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorRepository authorRepository;

	// Save author
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	// Get all author
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	// Get author by id
	public Optional<Author> getAuthorById(int id) {
		return authorRepository.findById(id);
	}

	// Update author
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}

	// Delete author
	public void deleteAuthor(Author author) {
		authorRepository.delete(author);
	}
}
