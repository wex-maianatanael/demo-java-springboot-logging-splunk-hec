package com.splunk.hec.logging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {

        log.info("Hello World");

        return "Hello World";
    }

    @PostMapping("/exception")
    public String postException(){
        try {
            throw new RuntimeException("forced error.");
        } catch (RuntimeException e) {
            log.error("Forced error for testing", e);
            return e.getMessage();
        }
    }
}
