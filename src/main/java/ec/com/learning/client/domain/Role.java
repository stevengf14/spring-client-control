package ec.com.learning.client.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Steven
 */
@Data
@Entity
@Table(name = "role")
public class Role implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String name;
    
}
