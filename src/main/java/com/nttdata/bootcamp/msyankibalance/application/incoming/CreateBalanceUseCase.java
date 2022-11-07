package com.nttdata.bootcamp.msyankibalance.application.incoming;

import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import reactor.core.publisher.Mono;

/**.*/
public interface CreateBalanceUseCase {

  Mono<Balance> createBalance(Balance balance);
}
