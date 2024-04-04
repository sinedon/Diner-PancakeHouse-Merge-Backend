package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import edu.iu.habahram.DinerPancakeHouseMerge.model.UserInformation;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@CrossOrigin
public class SignupController {
    CustomerRepository customerRepository;
    public SignupController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
