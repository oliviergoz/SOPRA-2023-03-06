package questJpa;

import java.time.LocalDate;
import java.time.Month;

import questJpa.dao.ContextJpa;
import questJpa.dao.DaoFormation;
import questJpa.entites.Formation;

public class AppTest {
	public static void main(String[] args) {
		test1();
		ContextJpa.destroy();
	}

	private static void test1() {
		Formation formation = new Formation("SOPRA_JAVA_1", LocalDate.of(2023, Month.FEBRUARY, 23));
		DaoFormation daoFormation = ContextJpa.getDaoFormation();
		daoFormation.save(formation);
	}
}
