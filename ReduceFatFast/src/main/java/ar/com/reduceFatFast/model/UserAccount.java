/**
 * 
 */
package ar.com.reduceFatFast.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
