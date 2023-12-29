package com.barisd.java12test.JUNIT_TEST;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class Test08Timeout {

    @Test
    @Timeout(value = 534,unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(500L);
        System.out.println("timeout deneme.");
    }
}
