package com.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenyunan on 2017/12/13.
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "hello";
    }

}
