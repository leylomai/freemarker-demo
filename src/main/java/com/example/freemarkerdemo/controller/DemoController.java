package com.example.freemarkerdemo.controller;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private Configuration configuration;

    @RequestMapping(value = "/freemarker/demo")
    public String demo() {
        return null;
    }
}
