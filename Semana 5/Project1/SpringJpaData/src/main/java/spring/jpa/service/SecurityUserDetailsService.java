package spring.jpa.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.jpa.dao.UserRepository;
import utils.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;

	public SecurityUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var obUser = this.userRepository.findByUsername(username);
		if(obUser.isPresent()) {
			return new SecurityUser(obUser.get());
		}
		throw new UsernameNotFoundException("Use not found" + username);
	}
	
	
}
