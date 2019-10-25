package cn.stt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AdminTestController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 16:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminTestController {

    @RequestMapping("/home")
    @ResponseBody
    public String productInfo() {
        return " admin home page ";
    }
}
