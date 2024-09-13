package spring.jpa.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class Security {

//	  @Bean
//	    public UserDetailsService userDetailsService() {
//		  var user = User.withUsername("user")
//			.password("123")
//			.roles("customer")
//			.build();
//		  
//		  return new InMemoryUserDetailsManager(user);
//	  		}
	  
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .httpBasic()
	        .and()
	        .authorizeHttpRequests(authorizeRequests -> 
	            authorizeRequests
	                .requestMatchers(HttpMethod.POST, "/rest/books").hasRole("ADMIN")
	                .requestMatchers(HttpMethod.DELETE, "/rest/books").hasRole("SUPERADMIN")
	                .requestMatchers(HttpMethod.GET, "/rest/books/**").authenticated()
	                .anyRequest().authenticated()
	        )
	        .csrf(csrf -> csrf.disable());
	    return http.build();
	}


	
	  @Bean
	  public PasswordEncoder passwordEnconder() {
		  return NoOpPasswordEncoder.getInstance();

	  }
	  
	
}

