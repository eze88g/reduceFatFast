package ar.com.reduceFatFast.repository;

import ar.com.reduceFatFast.model.UserAccount;

public abstract interface AccountRepository{
	
	public Boolean findByUsernameAndPassword(String username, String password);

	public boolean saveUser(UserAccount u);

}
