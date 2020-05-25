package com.aperture.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:UserProviderApplicationTests.properties")
public class UserProviderApplicationTests {

    @Test
    void contextLoads() {
    }

}
