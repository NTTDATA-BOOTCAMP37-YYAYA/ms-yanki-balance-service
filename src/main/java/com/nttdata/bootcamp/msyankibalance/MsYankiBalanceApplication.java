package com.nttdata.bootcamp.msyankibalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**.*/
@SpringBootApplication
@EnableEurekaClient
public class MsYankiBalanceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsYankiBalanceApplication.class, args);
  }

}
