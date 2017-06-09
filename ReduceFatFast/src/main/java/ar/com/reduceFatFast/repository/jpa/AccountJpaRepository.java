package ar.com.reduceFatFast.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

@Repository
@Profile("test")
public class AccountJpaRepository extends RFFJpaRepository<UserAccount> implements AccountRepository{
	
	public Boolean findByUsernameAndPassword(String username, String password) {
		return false;
	}

	public boolean saveUser(UserAccount u) {
		return false;
	}

}
