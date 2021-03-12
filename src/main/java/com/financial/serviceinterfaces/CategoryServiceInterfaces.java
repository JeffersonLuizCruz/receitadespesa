package com.financial.serviceinterfaces;

import java.util.List;

import com.financial.entity.Category;

public interface CategoryServiceInterfaces {
	
	public Category save(Category category);
	public Category getById(Long id);
	public List<Category> listAll();

}
