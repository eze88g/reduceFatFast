package ar.com.reduceFatFast.repository.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

@Repository
@Profile("test")
public interface AccountJpaRepository extends AccountRepository, JpaRepository<UserAccount, Long>{
	
	public Boolean findByUsernameAndPassword(String username, String password);

}
