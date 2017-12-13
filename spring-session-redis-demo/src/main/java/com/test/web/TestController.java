package com.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by chenyunan on 2017/12/13.
 */
@RestController
public class TestController {

    @GetMapping("test1")
    public void test(String gg, HttpSession httpSession) {
        httpSession.setAttribute("gg", gg);
    }

    @GetMapping("test2")
    public String test(@SessionAttribute("gg") String gg) {
        return gg;
    }

}
