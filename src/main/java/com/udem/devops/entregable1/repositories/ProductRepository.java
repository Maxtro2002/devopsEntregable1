package com.udem.devops.entregable1.repositories;

import com.udem.devops.entregable1.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String>{
}
