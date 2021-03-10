package com.financial.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ActivePersonRequestDto {
	
	@NotNull(message = "Campo null não é permitido!")
	private Boolean active;
	
	public Boolean transformToActive() {
		
//		if(active == null)
//			throw new BadRequestException("Erro no campo");
			
		return this.active;
	}

}
