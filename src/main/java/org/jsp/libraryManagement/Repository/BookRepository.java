package org.jsp.libraryManagement.Repository;

import java.util.List;

import org.jsp.libraryManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> getByGenre(String genre);

}
