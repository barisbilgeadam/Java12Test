package com.barisd.java12test;

import java.util.List;

public class UserRepository {
    public void save(){
        System.out.println("Kullanıcı Kayıt Edildi");
    }
    public void update(){
        System.out.println("Kullanıcı Güncellendi");
    }
    public List<String> findAll(){
        return List.of("Enes","Berre","Muhittin","Hilal","Tolga","Hakan");
    }

}
