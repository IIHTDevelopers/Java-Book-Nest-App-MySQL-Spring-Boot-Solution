package com.booknest.dto;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookDTO {

	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	private String author;

	@NotNull
	private Set<Long> categoryIds;

	@NotNull
	private BigDecimal price;

	private String description;

	public BookDTO() {
		super();
	}

	public BookDTO(Long id, @NotBlank String title, @NotBlank String author, @NotNull Set<Long> categoryIds,
			@NotNull BigDecimal price, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.categoryIds = categoryIds;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Set<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
