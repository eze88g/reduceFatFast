/**
 * 
 */
package ar.com.reduceFatFast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.reduceFatFast.dto.ResponseLogin;
import ar.com.reduceFatFast.dto.UserDto;
import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.service.AccountService;

/**
 * @author joaco
 *
 */
@Configuration
@Validated
@RestController
public class AccountController extends AbstractController{
	
	@Value("${errorLoginMessage}")
	private String errorLoginMessage;
	@Value("${successfulLoginMessage}")
	private String successfulLoginMessage;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(path="/save", method = RequestMethod.POST)
    public ResponseEntity<UserDto> save(@RequestParam (value ="user+", required=true) UserDto user){
    	ResponseEntity<UserDto> response;
    	 UserAccount u = new UserAccount();
    	 u.setUsername(user.getUsername());
		 if(this.getAccountService().save(u)){
			 response = new ResponseEntity<UserDto>(HttpStatus.OK);
		 }else{
			 response = new ResponseEntity<UserDto>(HttpStatus.FORBIDDEN);
		 }
		 return response;
    }

    @RequestMapping(path="/signIn", method = RequestMethod.POST)
    public ResponseEntity<UserDto> signIn(@RequestParam (value ="user+", required=true) UserDto user){
    	ResponseEntity<UserDto> response;
		 if(this.getAccountService().signIn(user.getUsername(), user.getPassword())){
			 response = new ResponseEntity<UserDto>(HttpStatus.OK);
		 }else{
			 response = new ResponseEntity<UserDto>(HttpStatus.FORBIDDEN);
		 }
		 return response;
    }
    
    @RequestMapping(path="/logout", method = RequestMethod.POST)
    public ResponseLogin logOut(){
		return null;
    }
    
    @RequestMapping(path="/createAccount", method = RequestMethod.POST)
    public ResponseLogin createAccount(){
		return null;
    }
    
    @RequestMapping(path="/deleteAccount", method = RequestMethod.POST)
    public ResponseLogin deleteAccount(){
		return null;
    }
    
    // setters and getters

	/**
	 * @return the accountService
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
    
}
