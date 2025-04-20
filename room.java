package com.example.demo.controller;

import com.example.demo.service.WorkerService;
import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class WorkerController {
    @Resource
    private WorkerService workerService;
    @PostMapping("/getallworker")
    @ResponseBody
    public Result getallworker() {
        System.out.println("getallworker");
        Result result = workerService.getallworker();
        return result;
    }
}
