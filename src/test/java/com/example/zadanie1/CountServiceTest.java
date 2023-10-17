package com.example.zadanie1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountServiceTest {
    private CountRepository countRepository = new CountRepository();
    private CountService countService = new CountService(countRepository);

    //проверка на получение строки, подсчет количества вхождений символа
    @Test
    void Test1() throws IllegalAccessException {
        String str = "aaaaabcccc";

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('c', 4);
        map.put('b', 1);

        countService.newData(str);

        assertEquals(countService.getMap(), map);
    }

    //проверка на то, что изначально у нас в HashMap ничего не было
    @Test
    void Test2() throws IllegalAccessException {
        Map<Character, Integer> map = new HashMap<>();

        assertEquals(countService.getMap(), map);
    }

    //проверка на несовпадение. Ввели строку с 4мя символами "а", сравниваем с 5, у нас не должно совпадать
    @Test
    void Test3() throws IllegalAccessException {
        String str = "aaaabcccc"; // a - 4, b - 1, c - 4

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('c', 4);
        map.put('b', 1);

        countService.newData(str);

        assertNotEquals(countService.getMap(), map);
    }

    //проверка на символ, которого вообще нет (вместо b - r)
    @Test
    void Test4() throws IllegalAccessException {
        String str = "aaaaabcccc";

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('c', 4);
        map.put('r', 1);

        countService.newData(str);

        assertNotEquals(countService.getMap(), map);
    }
}