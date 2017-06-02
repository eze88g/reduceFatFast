/**
 * 
 */
package ar.com.reduceFatFast.dto;

import java.util.List;

import ar.com.reduceFatFast.model.Measure;
import lombok.Data;

/**
 * @author joaco
 *
 */
public @Data class PersonDto {
	private long id;
	private List<Measure> measures;
}
