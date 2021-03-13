package com.financial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.entity.Category;
import com.financial.exceptions.NotFoundException;
import com.financial.repository.CategoryRepository;
import com.financial.serviceinterfaces.CategoryServiceInterfaces;

@Service
public class CategoryServiceImpl implements CategoryServiceInterfaces{
	
	@Autowired private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Long id) {
		Optional<Category> result = categoryRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("Não existe categoria com esse id: " + id));
	}

	@Override
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}
	
	

}
