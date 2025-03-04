package spring.jpa.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.jpa.entity.Authority;
import utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

	Optional<Authority> findByName(AuthorityName name);
	
}
