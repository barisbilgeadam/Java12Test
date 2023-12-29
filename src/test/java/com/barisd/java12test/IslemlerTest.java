package com.barisd.java12test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IslemlerTest {

    @Test
    void alanHesaplama() {
        Islemler islemler=new Islemler();
        int gelenDeger=islemler.alanHesaplama(10,5,Tur.UCGEN);
        int beklenenDeger=25;
        Assertions.assertEquals(beklenenDeger,gelenDeger);
    }

    @Test
    void ifadeUpperCase() {
        Islemler islemler=new Islemler();
        String deger = islemler.ifadeUpperCase("mert");
        Assertions.assertEquals("Mert",deger);
    }
    @Test
    void ifadeUpperGte5Lt10Test(){
        Islemler islemler=new Islemler();
        String deger = islemler.ifadeUpperCase("mertege");
        Assertions.assertEquals("MERTEGE",deger);
    }

    @Test
    void ifadeUpperGte10Test(){
        Islemler islemler=new Islemler();
        String deger = islemler.ifadeUpperCase("MertEge Kemal");
        Assertions.assertEquals("mertege kemal",deger);
    }

    @Test
    void decodeTokenExceptionTest() {
        Islemler islemler=new Islemler();
        assertEquals("bd1234",islemler.decodeToken("Bearer bd1234"));

        RuntimeException hata = assertThrows(RuntimeException.class, () -> islemler.decodeToken("kf1234"));
        assertEquals("Geçersiz token",hata.getMessage());

        RuntimeException hata2 = assertThrows(RuntimeException.class, () -> islemler.decodeToken("Bearer kf1234"));
        assertEquals("Geçersiz subtoken",hata2.getMessage());
    }
    @Test
    void timeoutTest(){
        // Bir metodun çalışma zaman aşımını test etmek için kullanılabilir.
        assertTimeout(Duration.ofMillis(6),()->{
            // buraya kodlar eklenir.
            try{
                System.out.println("timeout deneme başlangıç");
                Thread.sleep(2);
                System.out.println("timeout deneme bitiş");
            }catch (Exception e){

            }
        });
    }

    @Test
    void timeoutTest2(){
        // Bir metodun çalışma zaman aşımını test etmek için kullanılabilir.
        int alan=   assertTimeout(Duration.ofMillis(5),()->{
            System.out.println("timeout deneme başlangıç");
            Islemler islemler=new Islemler();
            System.out.println("timeout deneme bitiş");
            return islemler.alanHesaplama(5,10,Tur.UCGEN);
        });
        assertEquals(50,alan);

    }
}