package ec.com.learning.client.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;

/**
 *
 * @author Steven
 */

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String name;
    private String lastName;
    private String email;
    private String phone;
}
