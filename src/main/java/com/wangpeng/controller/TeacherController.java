package com.wangpeng.controller;

import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.TeacherService;
import com.wangpeng.utils.JsonUtil;
import com.wangpeng.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    /**
     * 查询所有化妆师
     * @param page  当前页码
     * @param limit 每页大小
     * @return 化妆师信息
     */
    @RequestMapping("queryTeachers.do")
    public PageResult queryTeachers(Integer page, Integer limit){
        //获取化妆师数量
        int count = service.getTeachersCount();
        //获取化妆师信息
        List<Teacher> teachers = service.findTeachersByPage(page,limit);
        //返回结果
        return PageResult.success(count, teachers);
    }

    /**
     * 查询所有化妆师
     * @return 化妆师信息
     */
    @RequestMapping("queryAllTeachers.do")
    public List<Teacher> queryAllTeachers(){
        return service.findAllTeachers();
    }

    /**
     * 根据tid查询化妆师
     * @return 化妆师信息
     */
    @RequestMapping("queryTeacher.do")
    public Teacher queryTeacher(int tid){
        return service.findTeacher(tid);
    }


    /**
     * 删除化妆师
     * @param json 化妆师对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteTeachers.do")
    public Integer deleteTeachers(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Teacher> teachers = JsonUtil.parseList(json, Teacher.class);
        return service.deleteTeachers(teachers);
    }

    /**
     * 添加一个化妆师
     * @param json 化妆师对象的json
     * @return 成功标志1
     */
    @RequestMapping("addTeacher.do")
    public Integer addTeacher(String json){
        Teacher teacher = JsonUtil.parseObject(json, Teacher.class);
        return service.addTeacher(teacher);
    }

    /**
     * 修改一个化妆师
     * @param json 化妆师对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateTeacher.do")
    public Integer updateTeacher(String json){
        Teacher teacher = JsonUtil.parseObject(json, Teacher.class);
        return service.updateTeacher(teacher);
    }

    /**
     * 获取化妆师总数
     * @return 化妆师总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getTeachersCount();
    }

    /**
     * 搜索化妆师
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索的参数
     *             {"tname":化妆师姓名,"tnum":化妆师编号}
     * @return 化妆师信息
     */
    @RequestMapping("searchTeachers.do")
    public PageResult searchTeachers(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询化妆师信息
        List<Teacher> teachers = service.searchTeachers(page, limit, searchParam);
        //返回结果
        return PageResult.success(count, teachers);
    }

}
