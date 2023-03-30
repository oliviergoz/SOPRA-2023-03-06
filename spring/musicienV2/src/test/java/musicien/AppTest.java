package musicien;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import musicien.beans.Guitare;
import musicien.beans.Musicien;
import musicien.config.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBean("guitariste", Musicien.class).performer();
		ctx.close();
	}
}
