package azo.developer.springauthenticationdemo.repository;

import azo.developer.springauthenticationdemo.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, String> {
}
