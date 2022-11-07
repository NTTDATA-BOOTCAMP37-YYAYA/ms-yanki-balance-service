package com.nttdata.bootcamp.msyankibalance.infrastructure.persistence.entity;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Balance")
public class BalanceEntity {

  @Id
  private String balanceId;
  private String accountId;
  private double balanceAmmount;

  /**.*/
  public static Balance toBalance(BalanceEntity balanceEntity) {
    Balance balance = new Balance();
    BeanUtils.copyProperties(balanceEntity, balance);
    return balance;
  }
  
  /**.*/
  public static BalanceEntity toBalanceEntity(Balance balance) {

    BalanceEntity balanceEntity = new BalanceEntity();
    BeanUtils.copyProperties(balance, balanceEntity);
    return balanceEntity;
  }
}
