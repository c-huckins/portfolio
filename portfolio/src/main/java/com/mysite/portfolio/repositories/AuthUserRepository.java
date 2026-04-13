package com.mysite.portfolio.repositories;

import com.mysite.portfolio.models.AuthorizedUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthorizedUser, String>{
    Optional<AuthorizedUser> findByUserName(String userName);
}
