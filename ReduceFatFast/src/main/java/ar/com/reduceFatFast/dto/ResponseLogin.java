/**
 * 
 */
package ar.com.reduceFatFast.dto;

import lombok.Data;

/**
 * @author joaco
 *
 */
public @Data class ResponseLogin {
	
	private Boolean success;
	private String message;
	
	public ResponseLogin(Boolean sucess, String message){
		this.setSuccess(sucess);
		this.setMessage(message);
	}
	
	protected ResponseLogin(){}

}
