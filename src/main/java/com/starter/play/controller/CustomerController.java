package com.starter.play.controller;
import com.starter.play.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<?>> getCustomer(@PathVariable Long id) {
        System.out.println(Thread.currentThread().getName() + " - Controller started");

        return customerService.getCustomerById(id)
                .thenApply(customer -> {
                    if (customer == null) {
                        return ResponseEntity.notFound().build();
                    } else {
                        System.out.println("exiting");
                        return ResponseEntity.ok(customer);
                    }
                }).exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return ResponseEntity.badRequest().body("Error: " + ex.getCause().getMessage());
                });

    }

}
