package cn.stt.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ProductTestController
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/24 16:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductTestController {

    @RequestMapping("/info")
    @ResponseBody
    public String productInfo() {
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principl instanceof UserDetails) {
            currentUser = ((UserDetails) principl).getUsername();
        } else {
            currentUser = principl.toString();
        }
        return " some product info,currentUser is: " + currentUser;
    }
}
