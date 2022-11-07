package com.nttdata.bootcamp.msyankibalance.application.outgoing;

import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import reactor.core.publisher.Mono;

/**.*/
public interface UpdateBalancePort {

  Mono<Balance> updateBalance(Balance balance);
}
