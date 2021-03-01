package com.financial.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.financial.entity.enums.TypeEntry;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter
@Entity(name = "entry")
public class Entry implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String description;


	@Column(nullable = false, updatable = true)
	private LocalDate expirationDate;

	private LocalDate paymentDate;


	private BigDecimal amount;

	@Column(columnDefinition = "text")
	private String observation;


	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TypeEntry type;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	
	

}