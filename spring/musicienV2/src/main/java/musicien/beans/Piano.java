package musicien.beans;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {
	@Override
	public void jouer() {
		System.out.println("je suis un piano");
	}
}
