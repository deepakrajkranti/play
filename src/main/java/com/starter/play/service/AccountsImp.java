package com.starter.play.service;

import com.starter.play.exception.EntityException;
import com.starter.play.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountsImp implements Accounts{

   @Override
    public CustomerRequest getCustomer() throws EntityException {
       CustomerRequest request = new CustomerRequest();
       request.setCustomerId(1L);
       request.setBranchId(101L);
       request.setBalance(new BigDecimal("5000.00"));
       return request;
//      throw new EntityException("error from user");
   }

}
