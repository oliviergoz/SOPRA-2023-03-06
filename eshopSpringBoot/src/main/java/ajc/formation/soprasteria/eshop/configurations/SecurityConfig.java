package ajc.formation.soprasteria.eshop.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	// configuration du filtre
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.antMatcher("/**")
					.csrf().disable()
					.authorizeRequests()
						.antMatchers("/").permitAll()
						.antMatchers("/achat/**").hasAnyRole("USER")
						.anyRequest().hasAnyRole("ADMIN")
					.and()
					.formLogin();
		
		//@formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		auth.inMemoryAuthentication()
				.withUser("olivier").password("{noop}olivier").roles("ADMIN")
				.and()
				.withUser("toto").password("{noop}toto").roles("USER")
				.and()
				.withUser("tutu").password("{noop}tutu").roles("USER");
		//@formatter:on
	}
}
