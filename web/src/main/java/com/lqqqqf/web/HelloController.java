package com.lqqqqf.web;

import com.lqqqqf.common.Escape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by apple on 16/6/15.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(@Escape String q) {
        System.out.println(q);
        return "hello";
    }
}
