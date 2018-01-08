package cn.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    private static Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(value = "/index") //把控制器不同的请求，映射到不同的方法上IndexController
    public ModelAndView index(){
        logger.info("hello!!!>>>>>");
        return new ModelAndView("index");
    }

    // 测试传入值
    @RequestMapping(value = "/welcome",method = RequestMethod.GET) //所要请求的路径
    public String welcome(@RequestParam(value = "username",required = false) String username){ //required=false是否为必须
        logger.info("hello!!! username:>>>>>" + username);
        return "index";
    }


    /*
    * 测试处理试图解析与传值
    * */
/*    @RequestMapping(value = "/test",method = RequestMethod.GET) //所要请求的路径
    public ModelAndView test(String username){ //required=false是否为必须
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",username); //要传入的值
        modelAndView.setViewName("index"); //逻辑视图名称
        return modelAndView;
    }*/


    /*@RequestMapping(value = "/test",method = RequestMethod.GET) //所要请求的路径
    public String test(String username, Model model){ //Model为数据模型
       // model.addAttribute("username",username); 指定key值
        model.addAttribute(username); //指定key值，默认为数据类型作为key值获取

        User user = new User();
        user.setUserName(username);
        model.addAttribute(user); //假如传入的值为user对象,默认user获取，即类型作为key
        return "index"; //返回逻辑视图
    }*/

    // 传入的是map
    @RequestMapping(value = "/test",method = RequestMethod.GET) //所要请求的路径
    public String test(String username, Map<String,Object> model){ //Model为数据模型
       model.put("username",username);
        return "index"; //返回逻辑视图
    }


}
