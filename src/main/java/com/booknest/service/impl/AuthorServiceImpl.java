package com.booknest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.AuthorDTO;
import com.booknest.entity.Author;
import com.booknest.repo.AuthorRepository;
import com.booknest.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AuthorDTO> getAllAuthors() {
		List<Author> authors = authorRepository.findAllAuthors();
		return authors.stream().map(author -> modelMapper.map(author, AuthorDTO.class)).collect(Collectors.toList());
	}

	@Override
	public AuthorDTO addAuthor(AuthorDTO authorDTO) {
		Author author = modelMapper.map(authorDTO, Author.class);
		Author savedAuthor = authorRepository.save(author);
		return modelMapper.map(savedAuthor, AuthorDTO.class);
	}
}
