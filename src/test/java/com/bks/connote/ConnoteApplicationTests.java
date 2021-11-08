package com.bks.connote;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ConnoteApplicationTests {
	@Autowired
	ConnoteGenerator connoteGenerator;

	private static CarrierAccount carrierAccount;


	@BeforeAll
	public static void setup(){
		 ConnoteApplicationTests. carrierAccount = new CarrierAccount(
				"FreightmateCourierCo",
				"ABC123",
				10,
				19604,
				19000,
				20000);
	}

	@Test
	void contextLoads() {
	}

	// Testing connote number generator
	@Test
	void testConnoteGenerator(){

		String connoteNumber = connoteGenerator.generateConnote(carrierAccount);
		Assertions.assertTrue(connoteNumber.equalsIgnoreCase("FMCCABC12300000196051"));

	}

}
