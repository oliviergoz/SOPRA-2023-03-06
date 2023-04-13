package ajc.formation.soprasteria.eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CompteException extends UsernameNotFoundException {
	public CompteException() {
		super("compte inconnu");
	}

	public CompteException(String message) {
		super(message);
	}
}
