package ar.com.reduceFatFast.repository.mysql;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

@Repository
@Profile({"dev","default"})
@Primary
public interface AccountMysqlRepository extends AccountRepository, CrudRepository<UserAccount, Long> {


}
