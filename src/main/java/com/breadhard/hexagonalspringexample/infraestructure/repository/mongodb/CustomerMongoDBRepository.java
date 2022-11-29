package com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb;

import com.breadhard.hexagonalspringexample.infraestructure.repository.mongodb.entity.CustomerMongoDBEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoDBRepository<C, S> extends MongoRepository<CustomerMongoDBEntity, String> {

}
