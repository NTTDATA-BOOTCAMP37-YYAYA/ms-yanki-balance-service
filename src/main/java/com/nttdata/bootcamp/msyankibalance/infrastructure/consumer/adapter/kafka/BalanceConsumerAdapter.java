package com.nttdata.bootcamp.msyankibalance.infrastructure.consumer.adapter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.msyankibalance.application.incoming.CreateBalanceUseCase;
import com.nttdata.bootcamp.msyankibalance.application.incoming.UpdateBalanceUseCase;
import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BalanceConsumerAdapter {

  
  @Autowired
  private UpdateBalanceUseCase updateBalanceUseCase;
  
  @Autowired
  private CreateBalanceUseCase createBalanceUseCase;

  
  @KafkaListener(topics = "${kafka.topic.balance.create.name}")
  public void listenerCreate(@Payload Balance balance) {
    createBalanceUseCase.createBalance(balance).block();
  }
  

}
