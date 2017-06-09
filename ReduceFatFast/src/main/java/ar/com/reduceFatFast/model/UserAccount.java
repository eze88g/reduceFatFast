/**
 * 
 */
package ar.com.reduceFatFast.model;

import java.util.Date;

import lombok.Data;

/**
 * @author joaco
 *
 */
//@Entity
public @Data class UserAccount {
	
	//@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private AccountStatus status;
	
	private Date created;
	private Date lastLogin;
}
