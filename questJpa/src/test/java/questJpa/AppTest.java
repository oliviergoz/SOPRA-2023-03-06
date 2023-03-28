package questJpa;

import java.time.LocalDate;
import java.time.Month;

import questJpa.dao.ContextJpa;
import questJpa.dao.DaoFormation;
import questJpa.dao.DaoStagiaire;
import questJpa.entites.Formation;
import questJpa.entites.Stagiaire;

public class AppTest {
	public static void main(String[] args) {
		test1();
		ContextJpa.destroy();
	}

	private static void test1() {
		DaoStagiaire daoStagiaire = ContextJpa.getDaoStagiaire();

		Stagiaire s1 = new Stagiaire("ppp", "ppp", "pppp", LocalDate.of(2000, Month.APRIL, 23), null);
		daoStagiaire.save(s1);
		Stagiaire s2 = new Stagiaire("zzz", "zzz", "zzz", LocalDate.of(2001, Month.APRIL, 23), null);
		daoStagiaire.save(s2);
		System.out.println(ContextJpa.getDaoStagiaire().findLessThan25year());

		daoStagiaire.findAll().stream().filter(s -> LocalDate.now().getYear() - s.getDateNaissance().getYear() < 25)
				.forEach(s -> {
					System.out.println(s);
				});
	}
}
