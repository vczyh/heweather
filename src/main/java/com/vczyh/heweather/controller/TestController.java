package com.vczyh.heweather.controller;

import com.vczyh.heweather.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

//    @GetMapping("/test")
//    public void test() {
//        testService.test2();
//    }
}
