package com.diaries.wedding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diaries.wedding.model.SecUsers;

public interface UserRepository extends MongoRepository<SecUsers, String> {
	SecUsers findByUsername(String userName);
}
