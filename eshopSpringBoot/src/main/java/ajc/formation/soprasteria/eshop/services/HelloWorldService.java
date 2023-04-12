package ajc.formation.soprasteria.eshop.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
//afficher "hello world" sur la console
public class HelloWorldService implements CommandLineRunner {

	// @Autowired de beans

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldService.class);

	@Override
	public void run(String... args) throws Exception {
		// les logger marchent avec des niveaux
		// ordre des niveaux:
		// trace
		// debug
		// info
		// warning
		// error

		// off =>pas log (seulement les fatal qu'on ne peut pas gerer)

		LOGGER.trace("trace");
		LOGGER.debug("debug");
		LOGGER.info("info");
		LOGGER.warn("warn");
		LOGGER.error("error");
		System.out.println("hello world");
	}

}
