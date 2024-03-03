package com.udem.devops.entregable1.repositories;

import com.udem.devops.entregable1.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, Long>{
}
