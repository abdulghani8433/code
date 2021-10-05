package postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import postgres.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	
Users findByUsername(String username);
	 
}
