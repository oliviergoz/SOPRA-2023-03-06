
import java.time.LocalDate;
import java.time.Month;

import formationJpa.dao.ContextJpa;
import formationJpa.dao.DaoFormation;
import formationJpa.entities.Formation;

public class AppTest {

	public static void main(String[] args) {
		test1();
		ContextJpa.destroy();
		
	}
	
	private static void test1() {
		Formation formation = new Formation("Sopra", LocalDate.of(2023, Month.FEBRUARY, 8));
		DaoFormation daoFormation = ContextJpa.getDaoFormation();
		daoFormation.save(formation);
		
		
	}
}
