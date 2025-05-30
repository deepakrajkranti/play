package com.starter.play.service;
import com.starter.play.entity.Customer;
import java.util.concurrent.CompletableFuture;

public interface CustomerService {
    CompletableFuture<Customer> getCustomerById(Long id);
}
