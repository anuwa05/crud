package com.example.demo.rest;

import com.example.demo.service.MerchantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
    private final com.example.demo.service.MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @GetMapping("/merchant")
    public void createMerchant() {
         merchantService.createMerchant("dede","dede");
    }
}
