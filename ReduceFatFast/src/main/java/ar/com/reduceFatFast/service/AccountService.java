/**
 * 
 */
package ar.com.reduceFatFast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

/**
 * @author joaco
 *
 */
@Service
@Configuration
@ImportResource("classpath:config.xml")
@Profile({"dev"})
public class AccountService {
	
	//@Autowired
	private AccountRepository accountRepository;
	
	public Boolean signIn(String username, String password) {
		return this.getAccountRepository().findByUsernameAndPassword(username, password);
	}
	
	// setters and getters

	/**
	 * @return the accountRepository
	 */
	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	/**
	 * @param accountRepository the accountRepository to set
	 */
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public boolean save(UserAccount u) {
		return this.getAccountRepository().save(u);
	}
}
