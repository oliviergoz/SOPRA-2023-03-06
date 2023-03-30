package demoSpring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	@Pointcut("execution(* demoSpring.*.Personne.demoAspect())")
	public void pointcut() {

	}

	@Pointcut("execution(String demoSpring.beans.Personne.getPrenom())")
	public void pointCutGetPrenom() {

	}

	// @Before("execution(* demoSpring.*.Personne.demoAspect())")
	@Before("pointcut()")
	public void methodeBefore(JoinPoint joinPoint) {
		System.out.println("methode before");
		System.out.println(joinPoint.getTarget());
	}

	// @After("execution(* demoSpring.*.Personne.demoAspect())")
	@After("pointcut()")
	public void methodeAfter() {
		System.out.println("methode after");
	}

	@AfterReturning(pointcut = "pointCutGetPrenom()", returning = "nomVariableContenantLeReturn")
	public void afterReturningGetPrenom(String nomVariableContenantLeReturn) {
		System.out.println("after returning:" + nomVariableContenantLeReturn);
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void afterThrowing() {
		System.out.println("probleme");
	}
}
