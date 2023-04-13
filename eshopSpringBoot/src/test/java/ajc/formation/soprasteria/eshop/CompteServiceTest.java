package ajc.formation.soprasteria.eshop;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.formation.soprasteria.eshop.entities.Compte;
import ajc.formation.soprasteria.eshop.services.CompteService;

@SpringBootTest
public class CompteServiceTest {

	@Autowired
	CompteService compteSrv;

	@Disabled
	@Test
	@Transactional
	@Commit
	void initCompte() {
		compteSrv.createAdmin(new Compte("admin", "admin"));
		compteSrv.createUser(new Compte("zozo", "zozo"));
		compteSrv.createUser(new Compte("tata", "tata"));

	}
}
