package com.example.demo.controller;

import com.example.demo.domain.Psw;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user)
    {
        Result result = userService.check(user.getUsername(), user.getPassword());
        System.out.println(result);
        return result;
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(String key,@RequestBody User user)
    {
        Result result = userService.addUser(user,key);
        System.out.println(result);
        return result;
    }

    @PostMapping("/getuser")
    @ResponseBody
    public Result getUser(@RequestBody User user)
    {
        Result result = userService.getUser(user);
        System.out.println(result);
        return result;
    }

    @PostMapping("/deleteuser")
    @ResponseBody
    public Result deleteUser(@RequestBody User user)
    {
        Result result = userService.deleteUser(user);
        return result;
    }

    @PostMapping("/getcurrentuser")
    @ResponseBody
    public Result getCurrentUser()
    {
        Result result = userService.getCurrentUser();
        return result;
    }


    @RequestMapping("/editpsw")
    @ResponseBody
    public Result editpsw(@RequestBody Psw psw)
    {
        System.out.println(psw);
        Result result = userService.editpsw(psw);
        return result;
    }

    @RequestMapping("/editpsw2")
    @ResponseBody
    public Result editpsw2(@RequestBody Psw psw,String username)
    {
        Result result = userService.editpsw2(psw, username);
        return result;
    }

}
