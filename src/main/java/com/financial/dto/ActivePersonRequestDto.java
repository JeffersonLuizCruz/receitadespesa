package com.financial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ActivePersonRequestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@NotNull(message = "Campo null não é permitido!")
	private Boolean active;
	
	public Boolean transformToActive() {
			
		return this.active;
	}

}
