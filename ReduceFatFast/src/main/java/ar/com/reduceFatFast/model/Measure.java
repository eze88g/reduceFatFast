/**
 * 
 */
package ar.com.reduceFatFast.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author joaco
 *
 */
//@Entity
public @Data class Measure {
		
		//@Id
		private long id;
		Long weight;
		Date date;
		Role tookBy;
}
