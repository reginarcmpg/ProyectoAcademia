package utils;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import spring.jpa.entity.Members;


@AllArgsConstructor
public class SecurityUser implements UserDetails{

	private final Members user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      
    	return user.getAuthorities().stream()
                .map(SecurityAuthority::new).toList();
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	
	

}
