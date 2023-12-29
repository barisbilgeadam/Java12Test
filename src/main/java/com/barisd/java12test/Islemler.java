package com.barisd.java12test;

public class Islemler {
    public int alanHesaplama(int uzunluk, int genislik, Tur tur){
        return switch (tur){
            case KARE, DIKDORTGEN -> uzunluk*genislik;
            case UCGEN -> (uzunluk*genislik)/2;
        };
    }

    public String ifadeUpperCase(String ifade){
        String sonIfade="";

        if(ifade.length()<5)
            sonIfade=ifade.substring(0,1).toUpperCase()+ifade.substring(1);
        else if(ifade.length()<10)
            sonIfade=ifade.toUpperCase();
        else
            sonIfade=ifade.toLowerCase();

        return sonIfade;
    }

    public String decodeToken(String token){
        if(token.contains("Bearer ")) {
            String subToken = token.substring(7);
            if (subToken.contains("bd"))
                return subToken;
            throw new RuntimeException("Geçersiz subtoken");
        }
        throw new RuntimeException("Geçersiz token");
    }
}
