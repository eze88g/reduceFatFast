/**
 * 
 */
package ar.com.reduceFatFast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;
import ar.com.reduceFatFast.repository.jpa.AccountJpaRepository;

/**
 * @author joaco
 *
 */
@Service
@Configuration
public class AccountService {
	
	@Autowired
	private AccountJpaRepository accountRepository;
	
	public Boolean signIn(String username, String password) {
		return false; //this.getAccountRepository().findByUsernameAndPassword(username, password);
	}
	
	// setters and getters

	/**
	 * @return the accountRepository
	 */
	public AccountJpaRepository getAccountRepository() {
		return accountRepository;
	}

	/**
	 * @param accountRepository the accountRepository to set
	 */
	public void setAccountRepository(AccountJpaRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public boolean save(UserAccount u) {
		return true; //this.getAccountRepository().saveUser(u);
	}
}
