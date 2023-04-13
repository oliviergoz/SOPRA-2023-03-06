package ajc.formation.soprasteria.eshop.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	// configuration du filtre
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.antMatcher("/**")
					.csrf().disable()
					.authorizeRequests()
						.antMatchers("/").permitAll()
						.antMatchers("/client/inscription").anonymous()
						.antMatchers("/achat/**").hasAnyRole("USER")
						.anyRequest().hasAnyRole("ADMIN")
					.and()
					.formLogin();
		
		//@formatter:on
	}

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
//		auth.inMemoryAuthentication()
//				.withUser("olivier").password("{noop}olivier").roles("ADMIN")
//				.and()
//				.withUser("toto").password("{noop}toto").roles("USER")
//				.and()
//				.withUser("tutu").password("{noop}tutu").roles("USER");
		//@formatter:on

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
