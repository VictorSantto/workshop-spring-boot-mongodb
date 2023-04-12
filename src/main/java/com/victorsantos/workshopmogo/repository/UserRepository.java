package com.victorsantos.workshopmogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victorsantos.workshopmogo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
