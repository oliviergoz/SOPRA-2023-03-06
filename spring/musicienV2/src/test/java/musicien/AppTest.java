package musicien;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		ctx.getBean("guitare", Guitare.class).jouer();
		ctx.close();
	}
}
