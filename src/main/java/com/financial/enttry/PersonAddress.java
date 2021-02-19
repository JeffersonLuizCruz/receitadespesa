package com.financial.enttry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
@Entity
public class PersonAddress implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(length = 150 ,nullable = false, unique = true)
	private String street;
	
	@Column(nullable = false, unique = true)
	private Long number;
	
	@Column(length = 150 ,nullable = false, unique = true)
	private String city;
	
	@Column(columnDefinition = "text")
	private String complement;
	

}
