package com.wangpeng.controller;

import com.wangpeng.pojo.OpenCourse;
import com.wangpeng.pojo.OpenCourseAndScore;
import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.OpenCourseService;
import com.wangpeng.utils.JsonUtil;
import com.wangpeng.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/openCourse")
public class OpenCourseController {

    @Autowired
    OpenCourseService service;

    /**
     * 查询妆前准备
     * @param page  当前页码
     * @param limit 每页大小
     * @return 妆前准备信息
     */
    @RequestMapping({"queryOpenCourses.do", "teacher/queryOpenCourses.do"})
    public PageResult queryOpenCourses(Integer page, Integer limit){
        //获取妆前准备数量
        int count = service.getOpenCoursesCount();
        //获取数据
        List<OpenCourse> openCourses = service.findOpenCoursesByPage(page,limit);
        //返回结果
        return PageResult.success(count, openCourses);
    }

    /**
     * 查询妆前准备(化妆师权限)
     * @param page  当前页码
     * @param limit 每页大小
     * @return 妆前准备信息
     */
    @RequestMapping("teacher/queryOpenCoursesByTeacher.do")
    public PageResult queryOpenCoursesByTeacher(Integer page, Integer limit, HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");
        //获取妆前准备数量
        int count = service.getOpenCoursesCountByTeacher(loginTeacher.getTid());
        //获取数据
        List<OpenCourse> openCourses = service.findOpenCoursesByPageByTeacher(page,limit,loginTeacher.getTid());
        //返回结果
        return PageResult.success(count, openCourses);
    }

    /**
     * 查询(租户权限)
     * @return 妆前准备信息
     */
    @RequestMapping("student/queryOpenCoursesByStudent.do")
    public PageResult queryOpenCoursesByStudent(Integer oid, HttpServletRequest req){
        //获取当前账号信息
        Student loginStudent =  (Student) req.getSession().getAttribute("loginObj");
        //获得数据
        List<OpenCourseAndScore> openCourseAndScores = service.findOpenCoursesByStudent(loginStudent.getSid());
        //返回结果
        return PageResult.success(openCourseAndScores.size(), openCourseAndScores);
    }

    /**
     * 查询所有妆前准备
     * @return 妆前准备信息
     */
    @RequestMapping("queryAllOpenCourses.do")
    public List<OpenCourse> queryAllOpenCourses(){
        return service.findAllOpenCourses();
    }

    /**
     * 删除妆前准备
     * @param json 妆前准备对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteOpenCourses.do")
    public Integer deleteOpenCourses(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<OpenCourse> openCourses = JsonUtil.parseList(json, OpenCourse.class);
        return service.deleteOpenCourses(openCourses);
    }

    /**
     * 添加一个妆前准备
     * @param json 妆前准备对象的json
     * @return 成功标志1
     */
    @RequestMapping("addOpenCourse.do")
    public Integer addOpenCourse(String json){
        OpenCourse openCourse = JsonUtil.parseObject(json, OpenCourse.class);
        return service.addOpenCourse(openCourse);
    }

    /**
     * 修改一个妆前准备
     * @param json 妆前准备对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateOpenCourse.do")
    public Integer updateOpenCourse(String json){
        OpenCourse openCourse = JsonUtil.parseObject(json, OpenCourse.class);
        return service.updateOpenCourse(openCourse);
    }

    /**
     * 获取妆前准备总数
     * @return 妆前准备总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getOpenCoursesCount();
    }

    /**
     * 搜索妆前准备
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"year":拍摄时间,"term":档期,"cid":组织id,"tid":化妆师id,"courseId":课程id}
     * @return 妆前准备信息
     */
    @RequestMapping({"searchOpenCourses.do", "student/searchOpenCourses.do", "teacher/searchOpenCourses.do"})
    public PageResult searchOpenCourses(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<OpenCourse> openCourses = service.searchOpenCourses(page, limit, searchParam);
        //返回结果
        return PageResult.success(count, openCourses);
    }

}
