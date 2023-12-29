package com.barisd.java12test.JUNIT_TEST;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test05TestOrder {

    @Test
    @Order(3)
    void test003(){
        System.out.println("test003 çalıştı");
    }

    @Test
    @Order(2)
    void test001(){
        System.out.println("test001 çalıştı");
    }

    @Test
    @Order(1)
    void test002(){
        System.out.println("test002 çalıştı");
    }


}
