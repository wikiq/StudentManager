package com.wangpeng.controller;

import com.wangpeng.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @Autowired
    WelcomeService service;

    /**
     * 管理员获取首页数量
     * @return 数量信息
     */
    @GetMapping("getAllCount.do")
    public Map<String, Integer> getAllCount() {
        return service.getAllCount();
    }

    /**
     * 租户获取首页数量
     * @param sid 租户id
     * @return 数量信息
     */
    @GetMapping("student/getAllCountByStudent.do")
    public Map<String, Integer> getAllCountByStudent(Integer sid) {
        return service.getAllCountByStudent(sid);
    }

    /**
     * 化妆师获取首页数量
     * @param tid 化妆师id
     * @return 数量信息
     */
    @GetMapping("teacher/getAllCountByTeacher.do")
    public Map<String, Integer> getAllCountByTeacher(Integer tid) {
        return service.getAllCountByTeacher(tid);
    }

}
