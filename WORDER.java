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
public interface WorkerMapper extends BaseMapper<Worker> {
}
public interface CurrentUserMapper extends BaseMapper<CurrentUser> {
    @Select("select * from currentuser order by id desc limit 1")
    public CurrentUser selectRecentUser();

    @Select("update currentuser set password=#{password} where username=#{username}")
    void updateByUsername(@Param("username") String username,@Param("password") String password);
}
@Data
@TableName(value="worker")
public class Worker {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String phone;
}
@Data
@TableName(value="student")
public class Student {
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;
    private String stuName;
    private String stuGender;
    private Date stuBir;
    private String stuPhone;
    private String building;
    private String roomnum;
    private String bednumber;

}
