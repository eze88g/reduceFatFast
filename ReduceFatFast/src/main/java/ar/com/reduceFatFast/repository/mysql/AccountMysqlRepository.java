package ar.com.reduceFatFast.repository.mysql;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

@Repository
@Profile({"dev","default"})
@Primary
public class AccountMysqlRepository extends RFFCrudRepository<UserAccount> implements AccountRepository {

	@Override
	public Boolean findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUser(UserAccount u) {
		// TODO Auto-generated method stub
		return false;
	}

}
