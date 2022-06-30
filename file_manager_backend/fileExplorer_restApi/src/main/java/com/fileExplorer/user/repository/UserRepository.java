package com.fileExplorer.user.repository;

import com.fileExplorer.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// @Repository spring 2.0 la beraber kullanmaya gerek yok
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{name : ?0, password : ?1}")
    User userAuthenticate(String name, String password);

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}

