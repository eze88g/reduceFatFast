/**
 * 
 */
package ar.com.reduceFatFast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author joaco
 *
 */
@Entity
public @Data class AccountStatus {
    private static final long ACTIVE_ID = 1l;
    private static final long INACTIVE_ID = 2l;
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String descripcion;
}
