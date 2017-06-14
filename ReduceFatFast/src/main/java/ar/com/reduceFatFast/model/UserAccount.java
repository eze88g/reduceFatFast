/**
 * 
 */
package ar.com.reduceFatFast.model;

import java.util.Date;

<<<<<<< HEAD
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

>>>>>>> 7a395380006c97e5603c6fcbf251b8a6891f4ae4
import lombok.Data;

/**
 * @author joaco
 *
 */
@Entity
public @Data class UserAccount {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	@ManyToOne
	private AccountStatus status;
	
	private Date created;
	private Date lastLogin;
}
