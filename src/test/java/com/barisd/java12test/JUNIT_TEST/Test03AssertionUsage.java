package com.barisd.java12test.JUNIT_TEST;

import com.barisd.java12test.Islemler;
import com.barisd.java12test.Tur;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test03AssertionUsage {

    private static Islemler islemler=new Islemler();

    @Test
    void standartAssertEquals(){
        // expected, actual   - beklenen,gerçek
        /**
         * ucgen 5,12 -> 30
         */
        assertEquals(30,islemler.alanHesaplama(5,12, Tur.KARE),"Bir yanlışlık olmuş. Düzelt gel.");



    }
    @Test
    void assertTrueTest(){
        assertTrue(30==islemler.alanHesaplama(5,12, Tur.UCGEN));
    }

    @Test
    void assertFalseTest(){
        assertFalse(30==islemler.alanHesaplama(5,12, Tur.UCGEN));
    }
    @Test
    void groupAssertions(){
        assertAll("İşlem Gruplarının Test Edilmesi",
                ()-> assertEquals(30,islemler.alanHesaplama(5,12, Tur.UCGEN)),
                ()-> assertTrue(60==islemler.alanHesaplama(5,12, Tur.DIKDORTGEN)),
                ()-> assertEquals(100,islemler.alanHesaplama(10,10, Tur.KARE))
        );
    }

}
