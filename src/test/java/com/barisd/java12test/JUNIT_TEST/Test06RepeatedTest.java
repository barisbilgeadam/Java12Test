package com.barisd.java12test.JUNIT_TEST;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test06RepeatedTest {
    @RepeatedTest(value = 10, name = "{displayName} --- {currentRepetition} / {totalRepetitions} ---")
    @DisplayName("repeatTest")
    void repeatTest(){
        System.out.println("Tekrarlayan testler");
    }
}
