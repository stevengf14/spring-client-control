package ec.com.learning.client.dao;

import ec.com.learning.client.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven
 */
public interface PersonDao extends CrudRepository<Person, Long>{
    
}
