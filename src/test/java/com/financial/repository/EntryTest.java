package com.financial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.financial.enttry.Category;
import com.financial.enttry.Entry;
import com.financial.enttry.Person;
import com.financial.enums.TypeEntry;

@SpringBootTest
public class EntryTest {
	
	@Autowired EntryRepository entryRepository;
	
	@Test
	public void saveTest() {
		
		Category category = new Category();
		category.setId(1L);
		
		Person person = new Person();
		person.setId(null);
		
		Entry entry = new Entry(
				null,
				"Pagamento",
				LocalDate.of(2021, 03, 14),
				LocalDate.now(),
				new BigDecimal(150),
				"Cliente fiel da empresa",
				TypeEntry.INCOME,
				null,
				null);
		
		Entry createEntry = entryRepository.save(entry);
				
		assertThat(createEntry.getId()).isEqualTo(1L);
	}

}
