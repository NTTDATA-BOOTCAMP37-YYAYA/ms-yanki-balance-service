package com.nttdata.bootcamp.msyankibalance.infrastructure.persistence.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.msyankibalance.application.outgoing.CreateBalancePort;
import com.nttdata.bootcamp.msyankibalance.application.outgoing.FindBalanceByAccountIdPort;
import com.nttdata.bootcamp.msyankibalance.application.outgoing.UpdateBalancePort;
import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;
import com.nttdata.bootcamp.msyankibalance.infrastructure.persistence.entity.BalanceEntity;

import reactor.core.publisher.Mono;

/**.*/
@Component
public class BalanceRepositoryAdapter implements UpdateBalancePort, 
                                                 FindBalanceByAccountIdPort, 
                                                 CreateBalancePort{

  @Autowired
  private ReactiveMongoBalanceRepository reactiveMongodb;

  @Override
  public Mono<Balance> updateBalance(Balance balance) {
    
    return reactiveMongodb.save(BalanceEntity.toBalanceEntity(balance))
                                 .map(BalanceEntity::toBalance);
  }

  @Override
  public Mono<Balance> findBalanceByAccountId(String accountId) {
   
    return reactiveMongodb.findBalanceByAccountId(accountId)
                           .map(BalanceEntity::toBalance);
  }

  @Override
  public Mono<Balance> createBalance(Balance balance) {
    return reactiveMongodb.insert(BalanceEntity.toBalanceEntity(balance))
                           .map(BalanceEntity::toBalance);
  }
  





}
