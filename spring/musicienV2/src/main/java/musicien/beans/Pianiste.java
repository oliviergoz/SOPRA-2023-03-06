package musicien.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {
	@Autowired
	@Qualifier("piano")
	private Instrument instrument;

	@Override
	public void performer() {
		System.out.println("le pianiste joue de son intrument");
		instrument.jouer();
	}
}
