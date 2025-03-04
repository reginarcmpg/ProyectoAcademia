package spring.jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;




import spring.jpa.dao.AuthorityRepository;
import spring.jpa.dao.UserRepository;
import spring.jpa.entity.Authority;
import spring.jpa.entity.Members;
import utils.AuthorityName;

@Component
public class Runner implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final AuthorityRepository autorityRepository;
	
	public Runner(UserRepository userRepository, AuthorityRepository autorityRepository) {
		this.userRepository = userRepository;
		this.autorityRepository = autorityRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Runner is executing...");
		
		if(this.autorityRepository.count() == 0) {
			this.autorityRepository.saveAll(List.of(
					new Authority(AuthorityName.ROLE_READER),
					new Authority(AuthorityName.ROLE_ADMIN),
					new Authority(AuthorityName.ROLE_SUPERADMIN)
					));	
		}
		
		if(this.userRepository.count() == 0) {
			this.userRepository.saveAll(List.of(
					
				new Members("Regina", "123", List.of(this.autorityRepository.findByName(AuthorityName.ROLE_ADMIN).get())),
				new Members("Daniel", "123", List.of(this.autorityRepository.findByName(AuthorityName.ROLE_READER).get())),
				new Members("Diego", "123", List.of(this.autorityRepository.findByName(AuthorityName.ROLE_SUPERADMIN).get()))
					
				));
		}
		
	}

}
