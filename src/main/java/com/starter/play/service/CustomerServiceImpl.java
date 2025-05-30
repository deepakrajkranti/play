package com.starter.play.service;
import com.starter.play.entity.Customer;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Override
    public CompletableFuture<Customer> getCustomerById(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a delay (e.g., external API or DB call)
            if(id<0){
                throw new IllegalArgumentException("Invalid customer ID: " + id);
            }
            sleep(1000);


            System.out.println(Thread.currentThread().getName() + " - Fetching customer with id: " + id);

            // Simulated customer data
            return new Customer(id, "John Doe", "john.doe@example.com");
        });
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
