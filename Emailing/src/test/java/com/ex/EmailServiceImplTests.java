package com.ex;

import com.ex.services.EmailServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailServiceImplTests {

    private EmailServiceImpl emailService;

    @BeforeEach
    public void initEachTest(){
        System.out.println("Initializing before test");
        emailService = new EmailServiceImpl();
        System.out.println("Done init");
    }

    /**
     * Throws exception when the inputs are null
     */
    @Test
    public void shouldThrowIllegalStateExceptionForNullDetailsForSendMail() {
        System.out.println("inside test1");
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {

            emailService.sendmail(null, null);
        });

        Assertions.assertEquals("Email id and message can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            emailService.sendmail("aneeshcm18@gmail.com", null);
        });

        Assertions.assertEquals("Email id and message can't be null", ex.getMessage(), "Method didn't throw with null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            // the test code
            emailService.sendmail(null, "mock message");
        });

        Assertions.assertEquals("Email id and message can't be null", ex.getMessage(), "Method didn't throw with null values");
    }

}
