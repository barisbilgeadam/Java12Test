package com.barisd.java12test.JUNIT_TEST;

import com.barisd.java12test.Islemler;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test02YasamDongusu {

    private static List<String> userList;
    private static Islemler islemler;

    @BeforeAll
    static void initAll(){
        islemler=new Islemler();
        System.out.println("@BeforeAll tüm testlerden önce 1 kere çalışır.");
    }

    @BeforeEach
    void init(){
        userList=new ArrayList<>();
        userList.add("Kemal");
        userList.add("Canan");
        System.out.println("@BeforeEach Testi Her bir testten önce çalıştı.");
    }

    @Test
    @DisplayName("Test001")
    void denemeTest1(){
        userList.add("DenemeTest1");
        System.out.println("Deneme testi çalıştı."+userList);
    }

    @Test
    @DisplayName("Test002")
    void denemeTest2(){
        userList.add("DenemeTest2");
        System.out.println("Deneme testi çalıştı."+userList);
    }
    @AfterEach
    void after(){
        System.out.println("@AfterEach Her bir testten sonra çalıştı.");
    }
    @AfterAll
    static void afterall(){
        System.out.println("@AfterAll tüm testlerden sonra 1 kere çalışır.");
    }
    @Test
    @DisplayName("Test003 \uD83D\uDE31")
    void failTest() throws InterruptedException {
        for (int i=1;i<=5;i++){
            Thread.sleep(1000L);
            if(i==4)
                Assertions.fail("Sayı beklenen aralıkta değildi.");
            else
                System.out.println("Normal çalışma durumu....");
        }
    }
    @Test
    @Disabled
    @DisplayName("Test004")
    void disabledTest(){
        System.out.println("Disabled Test");
    }
}
