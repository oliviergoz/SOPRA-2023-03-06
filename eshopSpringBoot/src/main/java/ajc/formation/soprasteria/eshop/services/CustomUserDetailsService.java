package ajc.formation.soprasteria.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteService compteSrv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteSrv.findByLogin(username);
	}

}
