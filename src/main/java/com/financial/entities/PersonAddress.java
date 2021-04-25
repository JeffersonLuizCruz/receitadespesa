package com.financial.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Embeddable
public class PersonAddress implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String street;
	private String number;
	private String city;
	private String complement;
	

}
