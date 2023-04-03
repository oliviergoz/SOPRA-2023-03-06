package demoMaven;

public class Calculatrice {

	public String getProfil() {
		return "ssss";
	}

	public double addition(double nombre1, double nombre2) {
		System.out.println("----------addition-----------");
		return nombre1 + nombre2;
	}

	public double soustraction(double nombre1, double nombre2) {
		System.out.println("----------soustraction-----------");
		return nombre1 - nombre2;
	}

	public double multiplicaiton(double nombre1, double nombre2) {
		System.out.println("----------multiplication-----------");
		return nombre1 * nombre2;
	}

	public double division(double nombre1, double nombre2) {
		System.out.println("----------division-----------");
		if (nombre2 == 0)
			throw new ArithmeticException("divion par 0 interdite");
		return nombre1 / nombre2;
	}
}
