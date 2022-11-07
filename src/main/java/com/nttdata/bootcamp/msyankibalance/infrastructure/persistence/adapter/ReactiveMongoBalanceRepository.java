package com.nttdata.bootcamp.msyankibalance.infrastructure.persistence.adapter;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.msyankibalance.infrastructure.persistence.entity.BalanceEntity;

import reactor.core.publisher.Mono;

/**.*/
public interface ReactiveMongoBalanceRepository extends ReactiveMongoRepository
                                                        <BalanceEntity, String> {
  
  

  @Query("{'accountId': ?0}")
  public Mono<BalanceEntity> findBalanceByAccountId(String accountId);


}