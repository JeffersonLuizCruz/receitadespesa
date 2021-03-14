package com.financial.util;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financial.entity.enums.TypeEntry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ResultEntry {
	
	private Long id;
	private String description;
	private LocalDate expirationDate;
	private LocalDate paymentDate;
	private BigDecimal amount;
	private TypeEntry type;
	private String category;
	private String person;

}
