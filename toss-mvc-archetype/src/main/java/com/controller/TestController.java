package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2017/7/12.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/default")
    public String jump1() {
        return "result";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String jump2() {
        return "result";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String jump3() {
        return "result";
    }
}
