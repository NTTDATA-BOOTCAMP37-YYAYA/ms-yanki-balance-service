package com.nttdata.bootcamp.msyankibalance.infrastructure.web.adapter.rest.response;

import com.nttdata.bootcamp.msyankibalance.domain.model.Balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**.*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBalance {
  
  private int httpStatus;
  private Balance account;
  private String message;

}