package ajc.formation.soprasteria.eshop.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigNew {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//@formatter:off
			return http.antMatcher("/**")
							.csrf().disable()
							.authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/client/inscription").anonymous()
								.antMatchers("/achat/**").hasAnyRole("USER")
								.anyRequest().hasAnyRole("ADMIN")
							.and()
							.formLogin()
					.and()
					.build();
				//@formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
