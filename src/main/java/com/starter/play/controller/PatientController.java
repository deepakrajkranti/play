package com.starter.play.controller;
import com.starter.play.exception.EntityException;
import com.starter.play.request.CustomerRequest;
import com.starter.play.service.AccountsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/customer")
public class PatientController {

    @Autowired
    private AccountsImp imp;

    // Change GET to POST if you need to receive a request body
    @PostMapping("/mate")
    public ResponseEntity<CustomerRequest> getCustomerDetails(@RequestBody CustomerRequest customerRequest) throws EntityException {
        CustomerRequest response = imp.getCustomer(); // You might want to use 'request' here
        return ResponseEntity.ok(response);
    }

    // This one is okay; it just returns a string
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Response");
    }
}