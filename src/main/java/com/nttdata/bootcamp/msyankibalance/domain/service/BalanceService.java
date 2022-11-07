package com.nttdata.bootcamp.msyankibalance.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.msyankibalance.application.incoming.CreateBalanceUseCase;
import com.nttdata.bootcamp.msyankibalance.application.incoming.FindBalanceByAccountIdUseCase;
import com.nttdata.bootcamp.msyankibalance.application.incoming.UpdateBalanceUseCase;
import com.nttdata.bootcamp.msyankibalance.application.outgoing.CreateBalancePort;
import com.nttdata.bootcamp.msyankibalance.application.outgoing.FindBalanceByAccountIdPort;
import com.nttdata.bootcamp.msyankibalance.application.outgoing.UpdateBalancePort;
import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import reactor.core.publisher.Mono;

/**.*/
@Service
public class BalanceService implements UpdateBalanceUseCase,
FindBalanceByAccountIdUseCase,
CreateBalanceUseCase{

  @Autowired
  private FindBalanceByAccountIdPort findBalanceByAccountIdPort;
  
  @Autowired
  private UpdateBalancePort updateBalancePort;
  
  @Autowired
  private CreateBalancePort createBalancePort;
  
  @Override
  public Mono<Balance> findBalanceByAccountId(String accountId) {
    return findBalanceByAccountIdPort.findBalanceByAccountId(accountId);
  }

  @Override
  public Mono<Balance> updateBalance(Balance balance) {
    return findBalanceByAccountIdPort.findBalanceByAccountId(balance.getAccountId())
        .map(findBalance -> {
          findBalance.setBalanceAmmount(findBalance.getBalanceAmmount()+ balance.getBalanceAmmount());
          return findBalance; })
        .flatMap(newBalance -> updateBalancePort.updateBalance(newBalance));
  }

  @Override
  public Mono<Balance> createBalance(Balance balance) {
    return createBalancePort.createBalance(balance);
  }

 




}
