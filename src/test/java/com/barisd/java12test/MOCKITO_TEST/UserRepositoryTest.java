package com.barisd.java12test.MOCKITO_TEST;

import com.barisd.java12test.UserRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.*;

import static org.mockito.Mockito.*;

public class UserRepositoryTest {
    @Test
    void findAllTest(){
        UserRepository repository= new UserRepository();
        repository.save();
        repository.update();
        List<String> all = repository.findAll();
        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void findAllMockTest(){
        UserRepository repository= mock(UserRepository.class);
        when(repository.findAll()).thenReturn(List.of("ahmet","canan"));
        List<String> userList = repository.findAll();
        assertFalse(userList.isEmpty());
    }

    @Test
    void firstMock(){
        List mockList=mock(ArrayList.class);
        mockList.add("Ali");
        mockList.forEach(System.out::println);
        verify(mockList).add("Ali");
        verify(mockList).add("Ahmet");
    }

    @Test
    void cevapDonme(){
        LinkedList linkedMockList=mock(LinkedList.class);
        when(linkedMockList.get(10)).thenReturn("Deniz");
        when(linkedMockList.get(0)).thenReturn(new ArrayIndexOutOfBoundsException());
        when(linkedMockList.get(1)).thenReturn(List.of("Ece","Kenan","Doruk"));

        System.out.println("10. değeri getir:"+linkedMockList.get(1));


        LinkedList linkedList=new LinkedList();
        System.out.println("10.değeri getir:"+linkedList.get(10));
    }

    @Test
    void bagimsizDegisken(){
        Map<Integer,String> mockmap=mock(HashMap.class);
        when(mockmap.get(anyInt())).thenReturn("Birşey dön");
        System.out.println("3.index..."+mockmap.get(3));
        System.out.println("33.index..."+mockmap.get(33));

        verify(mockmap,times(4)).get(anyInt());
    }

    @Test
    void metodCagrimSayisi(){
        LinkedList linkedMockList=mock(LinkedList.class);
        linkedMockList.add("ilk eleman");
        verify(linkedMockList).add("ilk eleman");

        linkedMockList.add("ikinci eleman");
        linkedMockList.add("ikinci eleman");

        verify(linkedMockList,times(2)).add("ikinci eleman");

        verify(linkedMockList,never()).add("Barış");

        verify(linkedMockList,atMostOnce()).add("ilk eleman");

        verify(linkedMockList,atLeastOnce()).add("ikinci eleman");
    }

    @Test
    void istisnaFirlatma(){
        LinkedList linkedMockList=mock(LinkedList.class);
        doThrow(new RuntimeException("mocktan hata fırlatildi")).when(linkedMockList).get(90);
        doThrow(new RuntimeException("Clear Çağırma Hatası")).when(linkedMockList).clear();
        System.out.println("90.index..."+linkedMockList.get(100));
        linkedMockList.clear();
    }

    @Test
    void siralamaTesti(){
        LinkedList linkedMockList=mock(LinkedList.class);
        linkedMockList.add("1. eleman");
        linkedMockList.add("2. eleman");

        InOrder siralama=inOrder(linkedMockList);
        siralama.verify(linkedMockList).add("1. eleman");
        siralama.verify(linkedMockList).add("2. eleman");
    }
}
