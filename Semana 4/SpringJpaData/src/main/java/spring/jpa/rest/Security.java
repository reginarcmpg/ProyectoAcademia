package spring.jpa.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;

@Configuration
public class Security {

	  @Bean
	    public UserDetailsService userDetailsService() {
		  var user = User.withUsername("user")
			.password("123")
			.roles("customer")
			.build();
		  
		  return new InMemoryUserDetailsManager(user);
	  		}
	  
	  @Bean
	  public PasswordEncoder passwordEnconder() {
		  return NoOpPasswordEncoder.getInstance();

	  }
	  
	
}
