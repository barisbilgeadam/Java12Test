package com.barisd.java12test.JUNIT_TEST;

import org.junit.jupiter.api.Test;

/**
 * Testlerin erişim belirteci olmaz.
 * geri dönüş tipi void olur.
 * bir metodun test olarak çalışması için @Test anotasyonu eklenmelidir.
 */

public class Test01IlkTest {

    @Test
    void ilkTest(){
        System.out.println("ilk test çalıştı.");
    }
}
