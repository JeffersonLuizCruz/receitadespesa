package com.financial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financial.enttry.Category;

@SpringBootTest
public class CategoryTest {
	
	@Autowired private CategoryRepository categoryRepository;
	
	
	@Test
	public void save() {
		Category category = new Category(null, "Alimentos", null);
		Category saveCategory = categoryRepository.save(category);
		
		assertThat(saveCategory.getId()).isEqualTo(1L);
		
	}

}
