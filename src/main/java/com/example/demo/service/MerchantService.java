package com.example.demo.service;

import com.example.demo.domain.Merchant;
import com.example.demo.exception.MerchantCreateException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MerchantService {

    public Merchant createMerchant(String name, String merchantId) {
        if(ObjectUtils.isEmpty(name)){
            throw new MerchantCreateException("Merchant Name Cannot empty");
        }
        if(ObjectUtils.isEmpty(merchantId)){
            throw new MerchantCreateException("Merchant Id Cannot empty");
        }
        return new Merchant();
    }

    public void deleteMerchant(String merchantId) {

    }
}
