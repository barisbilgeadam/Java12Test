package com.barisd.java12test.JUNIT_TEST;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class Test04OrtamaGoreTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void runTestOnPC(){
        System.out.println("runTestOnPC çalıştı.");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void runTestOnMAC(){
        System.out.println("runTestOnMAC çalıştı.");
    }

    @Test
    @EnabledOnOs({OS.WINDOWS,OS.LINUX})
    void runTestOnPCAndLinux(){
        System.out.println("runTestOnPCAndLinux çalıştı.");
    }
    @Test
    @EnabledOnOs(architectures = "x86_64")
    void runTestOnIntel(){
        System.out.println("runTestOnIntel x86_64");
    }
    @Test
    @DisabledOnOs(architectures = "aarch64")
    void runTestOnMac(){
        System.out.println("runTestOnMac aarch64");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_19)
    void runTestOnJre19(){
        System.out.println("runTestOnJre19");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_19)
    void runTestOnJreRange(){
        System.out.println("runTestOnJreRange 11 - 19");
    }
}
