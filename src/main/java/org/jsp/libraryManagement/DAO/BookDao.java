package org.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.Repository.BookRepository;
import org.jsp.libraryManagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	private BookRepository bookRepository;

	// Save book
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	// Get all books
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Get book by id
	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	// Update book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	// Delete book
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}

	// Get book by genre
	public List<Book> getBooksByGenre(String genre) {
		return bookRepository.getByGenre(genre);
	}
}
