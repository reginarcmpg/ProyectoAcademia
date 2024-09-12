package utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import spring.jpa.dao.AuthorityRepository;
import spring.jpa.dao.UserRepository;
import spring.jpa.entity.Authority;
import spring.jpa.entity.Members;

public class Runner implements CommandLineRunner {

	private final UserRepository userRepository;
	private final AuthorityRepository autorityRepository;
	
	
	
	public Runner(UserRepository userRepository, AuthorityRepository autorityRepository) {
		this.userRepository = userRepository;
		this.autorityRepository = autorityRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		if(this.autorityRepository.count() == 0) {
			this.autorityRepository.saveAll(List.of(
					new Authority(AuthorityName.READER),
					new Authority(AuthorityName.ADMIN),
					new Authority(AuthorityName.SUPERADMIN)
					));	
		}
		
		if(this.userRepository.count() == 0) {
			this.userRepository.saveAll(List.of(
					new Members("Regina", "123", List.of(this.autorityRepository.findByName(AuthorityName.ADMIN).get())),
					new Members("Daniel", "123", List.of(this.autorityRepository.findByName(AuthorityName.READER).get())),
					new Members("Diego", "123", List.of(this.autorityRepository.findByName(AuthorityName.SUPERADMIN).get()))
					));
		}
		
	}

}
