package com.booknest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booknest.dto.AuthorDTO;
import com.booknest.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
		List<AuthorDTO> authors = authorService.getAllAuthors();
		return ResponseEntity.ok(authors);
	}

	@PostMapping
	public ResponseEntity<AuthorDTO> addAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
		AuthorDTO createdAuthor = authorService.addAuthor(authorDTO);
		return ResponseEntity.ok(createdAuthor);
	}
}
