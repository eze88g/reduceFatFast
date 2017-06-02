package ar.com.reduceFatFast.repository;

import org.springframework.data.repository.Repository;

import ar.com.reduceFatFast.model.UserAccount;

public abstract interface AccountRepository extends Repository<UserAccount, Long>{
	
	public Boolean findByUsernameAndPassword(String username, String password);

	public boolean save(UserAccount u);

}
