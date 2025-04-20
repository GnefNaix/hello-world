package com.example.demo.controller;

import com.example.demo.domain.Pages;
import com.example.demo.domain.Student;
import com.example.demo.service.AccService;
import com.example.demo.service.StudentService;
import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @Resource
    private AccService accService;

    @RequestMapping("/getstudent")
    @ResponseBody
    public Result getStudent()
    {
        Result result= studentService.getStudent();
        return result;
    }
    @RequestMapping("/getstudentwithoutroom")
    @ResponseBody
    public Result getStudentwithoutroom()
    {
        Result result= studentService.getStudentwithoutroom();
        return result;
    }
    @RequestMapping("/getstudentbydorid")
    @ResponseBody
    public Result getStudentbydorid(Integer dorId)
    {

        Result result = studentService.getStudentbydorid(dorId);
        return result;
    }

    @RequestMapping("/getstudentbyanyinfo")
    @ResponseBody
    public Result getStudentbyanyinfo(@RequestBody Student student)
    {
        System.out.println(student);
        if (student.getStuBir() instanceof Date)
        {
            System.out.println("yes");
        }
        Result result = studentService.getStudentByAnyInfo(student);
        return result;
    }

    @RequestMapping("/getpagestudent")
    @ResponseBody
    public Result getpagestudent(@RequestBody Pages page)
    {
        System.out.println(page);

        Result result = studentService.getpagestudent(page);
        return result;
    }

    @RequestMapping("/addstudent")
    @ResponseBody
    public Result addStudent(@RequestBody Student student)
    {
        if (student.getStuId()==null)
        {
            return new Result(false,"学号不能为空");
        }

        Result result = studentService.addStudent(student);
        return result;

    }

    @RequestMapping("/deletestudent")
    @ResponseBody
    public Result deleteStudent(@RequestBody Student student)
    {
        List<Student> students =new ArrayList<>();
        students.add(student);
        accService.deleteAcc(students);
        Result result = studentService.deleteStudentById(student);
        return result;
    }

    @RequestMapping("/editstudent")
    @ResponseBody
    public Result editStudent(@RequestBody Student student)
    {

        Result result = studentService.updateStudentById(student);
        return result;
    }
}
