package ar.com.reduceFatFast.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;


/**
 * 
 */

/**
 * @author joaco
 *
 */
public @Data class UserDto {
	
	@Value("#{userDto.minCharaters}")
	private long minSize;
	@Value("#{userDto.maxCharaters}")
	private long maxSize;
	
	@Size(min=2, max=10)
	@NotNull
	private String username;
	
	@NotNull
	private String password;

}
