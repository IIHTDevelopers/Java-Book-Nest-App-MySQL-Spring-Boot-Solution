package com.booknest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.BookDTO;
import com.booknest.entity.Book;
import com.booknest.exception.NotFoundException;
import com.booknest.repo.BookRepository;
import com.booknest.repo.CategoryRepository;
import com.booknest.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<BookDTO> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}

	@Override
	public BookDTO getBookById(Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
		return modelMapper.map(book, BookDTO.class);
	}

	@Override
	public BookDTO addBook(BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		Book savedBook = bookRepository.save(book);
		return modelMapper.map(savedBook, BookDTO.class);
	}

	@Override
	public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setCategories(
				bookDTO.getCategoryIds().stream()
						.map(categoryId -> categoryRepository.findById(categoryId)
								.orElseThrow(() -> new NotFoundException("Category not found")))
						.collect(Collectors.toSet()));
		book.setPrice(bookDTO.getPrice());
		book.setDescription(bookDTO.getDescription());
		Book updatedBook = bookRepository.save(book);
		return modelMapper.map(updatedBook, BookDTO.class);
	}

	@Override
	public void deleteBook(Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
		bookRepository.delete(book);
	}

	@Override
	public List<BookDTO> searchBooks(String query) {
		List<Book> books = bookRepository.searchBooks(query);
		return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
	}
}
