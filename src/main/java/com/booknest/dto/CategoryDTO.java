package com.booknest.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {

	private Long id;

	@NotBlank
	private String name;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long id, @NotBlank String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
