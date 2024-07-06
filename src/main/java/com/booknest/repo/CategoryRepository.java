package com.booknest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booknest.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.name = :name")
	Category findByName(String name);

	@Query("SELECT c FROM Category c")
	List<Category> findAllCategories();
}
