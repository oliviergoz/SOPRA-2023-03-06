package musicien.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("musicien.beans")
@EnableAspectJAutoProxy
public class AppConfig {

}
