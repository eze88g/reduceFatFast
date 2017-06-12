package ar.com.reduceFatFast.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.UserAccount;

@Repository
public interface AccountJpaRepository extends CrudRepository<UserAccount,Long>{
	

}
