package musicien.beans;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument {
	public void jouer() {
		System.out.println("je suis une guitare");
	}
}
