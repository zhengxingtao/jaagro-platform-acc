package com.jaagro.account.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tony
 */
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan("com.jaagro.account.biz.mapper")
@ComponentScan("com.jaagro.account")
@EnableFeignClients(basePackages = {"com.jaagro.account.api"})
@EnableCaching
@SpringBootApplication
public class AccountWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountWebApplication.class, args);
    }
}
