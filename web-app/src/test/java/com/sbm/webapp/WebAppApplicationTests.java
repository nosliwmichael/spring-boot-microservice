package com.sbm.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:WebAppApplicationTests.properties")
class WebAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
