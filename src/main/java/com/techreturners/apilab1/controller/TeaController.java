package com.techreturners.apilab1.controller;

import com.techreturners.apilab1.model.Tea;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TeaController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/tealover")
    public String tea() {
        return "I love Tea..!!";
    }

    @GetMapping(value = "tea")
    public Tea tea(@RequestParam(value = "name", defaultValue = "Oolang") String name) {
        return new Tea(counter.incrementAndGet(), name);
    }
}
