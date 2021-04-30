package com.financial.services.crudservice;

import java.util.List;

import com.financial.entities.Category;

public interface CategoryService {
	
	public Category save(Category category);
	public Category getById(Long id);
	public List<Category> listAll();

}
