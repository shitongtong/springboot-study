package cn.stt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SecurityController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 15:18
 * @Version 1.0
 */
@Controller
public class SecurityController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello ,spring security!";
    }
}
