package azo.developer.springauthenticationdemo.repository;

import azo.developer.springauthenticationdemo.entity.AuthoritiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity, Long> {
}
