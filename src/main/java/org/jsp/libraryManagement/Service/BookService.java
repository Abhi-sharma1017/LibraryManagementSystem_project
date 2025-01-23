package org.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.libraryManagement.DAO.AuthorDao;
import org.jsp.libraryManagement.DAO.BookDao;
import org.jsp.libraryManagement.DTO.ResponseStructure;
import org.jsp.libraryManagement.Exception.IdNotFoundException;
import org.jsp.libraryManagement.entity.Author;
import org.jsp.libraryManagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	AuthorDao authorDao;

	// save book
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
		Optional<Author> author = authorDao.getAuthorById(book.getAuthor().getId());
		if (author.isPresent()) {
			Book recieveBook = bookDao.saveBook(book);
			recieveBook.setAuthor(author.get());
			ResponseStructure<Book> structure = new ResponseStructure<Book>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(recieveBook);
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException();
		}

	}

	// get all books
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
		List<Book> listOfBooks = bookDao.getAllBooks();

		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(listOfBooks);
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}

	// get book by id
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id) {
		Optional<Book> opt = bookDao.getBookById(id);

		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if (opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

	// update book
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book) {
		Book updatedBook = bookDao.updateBook(book);

		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(updatedBook);
		return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
	}

	// delete book
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id) {
		Optional<Book> opt = bookDao.getBookById(id);

		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if (opt.isPresent()) {
			Book book = opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			bookDao.deleteBook(book); // opt.get()
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

	// get books by genre
	public ResponseEntity<ResponseStructure<List<Book>>> getBooksByGenre(String genre) {
		List<Book> listOfBooks = bookDao.getBooksByGenre(genre);

		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(listOfBooks);
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}

}
