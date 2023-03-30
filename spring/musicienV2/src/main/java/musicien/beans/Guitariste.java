package musicien.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {
	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

	@Override
	public void performer() {
		System.out.println("le guitariste joue de la guitare");
		instrument.jouer();
	}
}
