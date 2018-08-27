package com.winter.controller;

import com.winter.model.User;
import com.winter.service.UserService;
import com.winter.utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService ;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{userName}/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("userName") String userName,@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
       System.out.print(userName);
        return userService.findAllUser(userName,pageNum,pageSize);
    }


    @RequestMapping(value="/hello")
    public String welcome(ModelMap map){
        Date date = new Date();
        redisService.set("name","QQQ");
        map.addAttribute("userList",redisService.get("name"));
        System.out.println("AAA"+redisService.get("name"));
        return "thymeleaf/hello";
    }
}