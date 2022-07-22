package dio.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.spring.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT e From User e JOIN FETCH e.roles WHERE e.roles WHERE e.username = (:username)")
	public User findByUserName(@Param ("username") String username);
}
