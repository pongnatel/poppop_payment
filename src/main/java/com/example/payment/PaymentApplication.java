package com.example.payment;

import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
    @GetMapping(path = "/ping")
    public String hello() {
        return "Hello";
    }

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment")
    public String postPaymentIntent() throws StripeException {
        System.out.printf("hello");
        return paymentService.createPaymentIntent();
    }
}
