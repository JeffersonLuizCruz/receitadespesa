package com.financial.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Sertifica se existe algum usuário existente ou inativo.
 * */

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private String msg;
}
