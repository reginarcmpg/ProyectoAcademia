package utils;

import org.springframework.security.core.GrantedAuthority;
import lombok.AllArgsConstructor;
import spring.jpa.entity.Authority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

	private final Authority authoriry;
	
	@Override
	public String getAuthority() {
	 return authoriry.getName().toString();
	}
	

}
