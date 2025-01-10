package com.ust.repository;

import com.ust.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, BigInteger> {

    Optional<UserModel> findByUserName(String userName);

}
