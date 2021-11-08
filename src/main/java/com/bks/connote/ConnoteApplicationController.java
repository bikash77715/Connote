package com.bks.connote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connoteApi")
public class ConnoteApplicationController {

    @Autowired
    private ConnoteGenerator connoteGenerator;

    //function that accepts a carrier account
    @PostMapping("/carrierAccount")
    public String acceptCarrierAccount(@RequestBody CarrierAccount carrierAccount){

        return connoteGenerator.generateConnote(carrierAccount);
    }

}
