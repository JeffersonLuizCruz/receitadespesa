package com.financial.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Embeddable
public class PersonAddress implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(length = 150)
	private String street;
	

	private Long number;
	
	@Column(length = 150)
	private String city;
	
	@Column(columnDefinition = "text")
	private String complement;
	

}
