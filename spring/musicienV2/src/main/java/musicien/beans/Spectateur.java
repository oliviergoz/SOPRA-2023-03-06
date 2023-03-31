package musicien.beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("pianiste")
	private Musicien pianiste;

	@Pointcut("execution(* musicien.beans.Guitariste.performer())")
	public void performerG() {

	}
	
	
	private void telephoneOff() {
		System.out.println("couper telephone");
	}
	
	private void sasseoir() {
		System.out.println("s'asseoir");
	}

	@Pointcut("execution(* musicien.beans.Pianiste.performer())")
	public void performerP() {

	}

	@Pointcut("execution(* musicien.beans.Musicien.performer())")
	public void performer() {

	}

	@Before("performerG()")
	public void installation() {
		System.out.println("les spectateurs s'installent");
		telephoneOff();
		sasseoir();
	}

	@After("performerG()")
	public void suivant() {
		pianiste.performer();
	}

	@After("performerP()")
	public void partir() {
		System.out.println("les spectateurs partent");
	}

	@AfterReturning(pointcut = "performer()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "performer()")
	public void siffler() {
		System.out.println("siffler");
	}
}
