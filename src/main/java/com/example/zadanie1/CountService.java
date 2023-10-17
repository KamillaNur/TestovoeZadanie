package com.example.zadanie1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CountService {
    private final CountRepository countRepository;

    public Map<Character, Integer> getMap() throws IllegalAccessException {
        Map<Character, Integer> map = countRepository.getAllMapp();
        if (map == null) {
            throw new IllegalAccessException();
        }
        return map;
    }

    public void newData(String str) throws IllegalAccessException {

        Map<Character, Integer> map = new HashMap<>();

        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        countRepository.save(sortedMap);
    }
}
