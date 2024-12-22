package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        try {
            String hashedPwd = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashedPwd);
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are successfully saved");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User Registration failed");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Exception occurred: "+exception.getMessage());
        }
    }
}