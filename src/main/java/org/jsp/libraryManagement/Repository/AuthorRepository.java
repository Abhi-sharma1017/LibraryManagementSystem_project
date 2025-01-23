package org.jsp.libraryManagement.Repository;

import org.jsp.libraryManagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Integer>{

}
