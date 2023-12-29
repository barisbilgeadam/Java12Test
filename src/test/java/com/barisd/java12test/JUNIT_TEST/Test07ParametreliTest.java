package com.barisd.java12test.JUNIT_TEST;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;

public class Test07ParametreliTest {

    @ParameterizedTest
    @ValueSource(ints={5,400,25,99,80})
    void testParametreli(int sayi){
        Assertions.assertTrue(sayi>50);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings={""," ","\t","\n","Deneme"})
    void testParametreliNullEmptyData(String ifade){
        /**
         * String ifade;  -> null
         * String ifade="" -> empty
         * String ifade=" " -> blank
         */
        Assertions.assertTrue(ifade==null || ifade.trim().isEmpty());
    }

    @ParameterizedTest
    @EnumSource(names = {"ERKEK","KADIN","BELIRTMEK_ISTEMIYOR"})
    void testEnums(Cinsiyet cinsiyet){
        Assertions.assertTrue(EnumSet.of(Cinsiyet.ERKEK,Cinsiyet.KADIN).contains(cinsiyet));
    }
    /**
     * CSV : Comma Seperated Value
     * kaynak.csv -> "ahmet, 40" ,"ali, 30","engin, 25"
     */

    @ParameterizedTest
    @CsvSource({
            "ahmet, 40",
            "ali, 30",
            "engin, 25" ,
            "tuna, 45",
            "kenan, 60"
    })
    void testWithCsv(String ad, int yas){
        System.out.println("Ad:"+ad);
        System.out.println("Yaş:"+yas);
        System.out.println("----------------------");
        Assertions.assertTrue(yas<40);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/userlist.csv",numLinesToSkip = 1)
    void testWithCsvFile(String ad, int yas){
        System.out.println("Ad:"+ad);
        System.out.println("Yaş:"+yas);
        System.out.println("----------------------");
        Assertions.assertTrue(yas<40);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/userlist.csv",numLinesToSkip = 1)
    void testWithCsvFileWithObject(ArgumentsAccessor accessor){
        User user=new User(
                accessor.getString(0),
                accessor.getInteger(1)
        );
        System.out.println("User:"+user);
        System.out.println("----------------------");
        Assertions.assertTrue(user.getYas()<40);
    }
}
