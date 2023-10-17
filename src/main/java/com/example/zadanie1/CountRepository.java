package com.example.zadanie1;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class CountRepository {
    private final Map<Character, Integer> story = new LinkedHashMap<>();;

    public Map<Character, Integer> getAllMapp() {
        return story;
    }

    public void save(Map<Character, Integer> map) throws IllegalAccessException {
        if (map == null) {
            throw new IllegalAccessException();
        }
        story.clear();
        story.putAll(map);
    }
}
