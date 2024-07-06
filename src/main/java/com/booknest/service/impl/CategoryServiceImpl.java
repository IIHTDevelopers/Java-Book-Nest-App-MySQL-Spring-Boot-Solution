package com.booknest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.CategoryDTO;
import com.booknest.entity.Category;
import com.booknest.repo.CategoryRepository;
import com.booknest.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoryRepository.findAllCategories();
		return categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		Category savedCategory = categoryRepository.save(category);
		return modelMapper.map(savedCategory, CategoryDTO.class);
	}
}
