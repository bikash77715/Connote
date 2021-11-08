package com.bks.connote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnoteGenerator {
    private final String prefix = "FMCC"; // default prefix for the organization

    @Autowired
    private ConsoleLogger logger; // for logging system events in console

    // function to generate the connote number
    public String generateConnote(CarrierAccount carrierAccount) {
        if (!carrierAccount.getCarrierName().equalsIgnoreCase("FreightmateCourierCo"))
            return "Invalid carrier name.";

        // consignment index for current connote number
        int consignmentIndex = carrierAccount.getLastUsedIndex()+1;

        // checking if the consignment index lies in allowed range (inclusive interval)
        if(!(consignmentIndex>=carrierAccount.getRangeStart()
                && consignmentIndex<=carrierAccount.getRangeEnd()))
            return "Consignment index went went out of bound.";

        return prefix
                +carrierAccount.getAccountNumber()
                +String.format("%0"+String.valueOf(carrierAccount.getDigits())+"d", consignmentIndex)
                +String.valueOf(calculateChecksum(consignmentIndex));
    }

    //function to calculate checksum for the current consignment index
    private int calculateChecksum(int consignmentIndex) {
        int sum1=0,sum2=0;

        while(consignmentIndex>0){
            sum1+=consignmentIndex%10;
            consignmentIndex/=10;

            if(consignmentIndex>0){
                sum2+=consignmentIndex%10;
                consignmentIndex/=10;
            }
        }
        sum1*=3;
        sum2*=7;
        int totalSum = sum1+sum2;
        logger.log(String.format(" \n Calculating " +
                "\n sum1: %d sum2: %d and totalSum: %d", sum1, sum2, totalSum));

        // Calculate checksum by substracting the sum of partial sums from its next multiple of 10
        return (int) Math.pow(10, String.valueOf(totalSum).length())-totalSum;
    }
}
