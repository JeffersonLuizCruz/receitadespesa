package com.financial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financial.entity.Category;

@SpringBootTest
public class CategoryTest {
	
	@Autowired private CategoryRepository categoryRepository;
	
	
	@Test
	public void saveTest() {
		Category category = new Category(null, "Alimentos", null);
		Category saveCategory = categoryRepository.save(category);
		
		assertThat(saveCategory.getId()).isEqualTo(1L);
		
	}
	
	@Test
	public void getByIdTest() {
		Optional<Category> getById = categoryRepository.findById(1L);
		
		assertThat(getById.get().getName()).isEqualTo("Alimentos");
	}
	
	@Test
	public void listAllTest() {
		List<Category> listAll = categoryRepository.findAll();
		
		assertThat(listAll.size()).isEqualTo(2);
	}

}
