package com.example.zadanie1;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController("/count")
@AllArgsConstructor
public class CountController {
    private final CountService countService;

    @GetMapping("/list")
    public Map<Character, Integer> getMap() throws IllegalAccessException {
        return countService.getMap();
    }

    @PostMapping("/newStr")
    public void getMap(@RequestParam("str") String str) throws IllegalAccessException {
        countService.newData(str);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public String handle(IllegalAccessException e){
        log.error(e.getMessage());
        return "BROKE";
    }
}
