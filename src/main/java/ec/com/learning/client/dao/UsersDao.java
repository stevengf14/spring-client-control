package ec.com.learning.client.dao;


import ec.com.learning.client.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Steven
 */
public interface UsersDao extends JpaRepository<Users, Long>{
    Users findByUsername(String username);
}
