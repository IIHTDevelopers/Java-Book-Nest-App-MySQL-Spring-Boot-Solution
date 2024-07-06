package com.booknest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booknest.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query("SELECT a FROM Author a WHERE a.name = :name")
	Author findByName(String name);

	@Query("SELECT a FROM Author a")
	List<Author> findAllAuthors();
}
