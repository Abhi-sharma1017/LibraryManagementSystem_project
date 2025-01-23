package org.jsp.libraryManagement.Controller;

import java.util.List;

import org.jsp.libraryManagement.DTO.ResponseStructure;
import org.jsp.libraryManagement.Service.BookService;
import org.jsp.libraryManagement.entity.Book;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	// save book
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	// get all books
	@GetMapping("/books")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
		return bookService.getAllBooks();
	}

	// get book by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	// update book
	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

	// delete book
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}

	// get books by genre
	@GetMapping("genre")
	public ResponseEntity<ResponseStructure<List<Book>>> getBooksByGenre(@RequestParam String genre) {
		return bookService.getBooksByGenre(genre);
	}
}
