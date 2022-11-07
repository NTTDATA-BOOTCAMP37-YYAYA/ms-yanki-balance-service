package com.nttdata.bootcamp.msyankibalance.infrastructure.web.adapter.rest;


import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msyankibalance.application.incoming.CreateBalanceUseCase;
import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;
import com.nttdata.bootcamp.msyankibalance.infrastructure.web.adapter.rest.response.ResponseBalance;

import reactor.core.publisher.Mono;

/**.*/
@RestController
@RequestMapping("/yankiBalance")
public class BalanceControllerAdapter {

  final Logger logger = LoggerFactory.getLogger(BalanceControllerAdapter.class);
   
  

  @Autowired
  private  CreateBalanceUseCase createBalanceUseCase;

 
  
  /**.*/
  @PostMapping()
  public Mono<ResponseEntity<ResponseBalance>> createAccount(@RequestBody Balance balance) {
    //TODO
    return   createBalanceUseCase.createBalance(balance)
        .flatMap(newAccount -> Mono.just(new ResponseEntity<ResponseBalance>(
                 new ResponseBalance(HttpStatus.SC_NOT_FOUND, newAccount, "Account has been created"),
                 null, HttpStatus.SC_NOT_FOUND)))
       .onErrorResume(e->Mono.just(new ResponseEntity<ResponseBalance>(
           new ResponseBalance(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, e.getMessage()),
           null, HttpStatus.SC_INTERNAL_SERVER_ERROR)));
  
  }
}
