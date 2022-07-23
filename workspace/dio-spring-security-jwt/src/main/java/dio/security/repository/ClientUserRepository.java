package dio.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dio.security.model.ClientUser;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Integer> {

	@Query("SELECT e From ClientUser e JOIN FETCH e.roles WHERE e.username= (:username)")
	public ClientUser findByUserName(@Param("username") String username);
}
