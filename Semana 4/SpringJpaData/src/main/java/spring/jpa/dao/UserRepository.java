package spring.jpa.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.entity.Members;


public interface UserRepository extends JpaRepository<Members, Integer> {

    Optional<Members> findByUsername(String username);
}