package com.booknest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booknest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.title LIKE %:query% OR b.author LIKE %:query%")
	List<Book> searchBooks(@Param("query") String query);

	@Query("SELECT b FROM Book b WHERE b.id = :bookId")
	Book findBookById(@Param("bookId") Long bookId);
}
