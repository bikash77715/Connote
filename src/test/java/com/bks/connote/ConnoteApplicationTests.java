package com.bks.connote;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
class ConnoteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAcceptCarrierAccount() throws Exception{
		/* input
		{
			"carrierName":"FreightmateCourierCo",
				"accountNumber":"ABC123",
				"digits":10,
				"lastUsedIndex":19604,
				"rangeStart":19000,
				"rangeEnd":20000
		}
		# output
				FMCC123ABC00000196051

		 */
		CarrierAccount carrierAccount = new CarrierAccount(
				"FreightmateCourierCo",
				"ABC123",
				10,
				19604,
				19000,
				2000);
		ConnoteApplicationController controller = new ConnoteApplicationController();

		Assertions.assertTrue(controller.acceptCarrierAccount(carrierAccount).equals("FMCC123ABC00000196051"));
	}

}
