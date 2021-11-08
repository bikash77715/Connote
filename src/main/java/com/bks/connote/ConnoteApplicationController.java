package com.bks.connote;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connoteApi")
public class ConnoteApplicationController {

    //function that accepts a carrier account
    @PostMapping("/carrierAccount")
    public String acceptCarrierAccount( CarrierAccount carrierAccount){
        ConnoteGenerator connoteGenerator = ConnoteGenerator.getInstance();
        return connoteGenerator.generateConnote(carrierAccount);
    }

}
