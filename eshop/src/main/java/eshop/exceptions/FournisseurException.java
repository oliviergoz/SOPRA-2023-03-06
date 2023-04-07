package eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FournisseurException extends RuntimeException {
	public FournisseurException() {

	}

	public FournisseurException(String message) {
		super(message);
	}
}
