package cn.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
*
*  参数可传入数组
* */

@Controller
@RequestMapping("/user")  //区别不同的Controllerl类
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    // 测试传入值
    @RequestMapping("/welcome") //所要请求的路径
    public String welcome(@RequestParam String username){
        logger.info("user, username:>>>>>" + username);
        return "index";
    }
}
