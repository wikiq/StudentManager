package com.wangpeng.controller;

import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.ClazzService;
import com.wangpeng.utils.JsonUtil;
import com.wangpeng.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    ClazzService service;

    /**
     * 查询组织
     * @param page 当前页码
     * @param limit 每页大小
     * @return 组织信息
     */
    @RequestMapping("queryClazzs.do")
    public PageResult queryClazzs(Integer page, Integer limit){
        //获取数量
        int count = service.getAmount();
        //获取数据
        List<Clazz> clazzes = service.queryClazzs(page, limit);
        //返回结果
        return PageResult.success(count, clazzes);
    }

    /**
     * 查询所有组织
     * @return 组织信息
     */
    @RequestMapping({"queryAllClazzs.do", "student/queryAllClazzs.do"})
    public List<Clazz> queryAllClazzs(){
        return service.queryAllClazzs();
    }

    /**
     * 根据化妆师查询所有组织
     * @param req HttpServletRequest
     * @return
     */
    @RequestMapping("teacher/queryAllClazzsByTeacher.do")
    public List<Clazz> queryAllClazzsByTeacher(HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");
        return service.queryAllClazzsByTeacher(loginTeacher.getTid());
    }

    /**
     * 删除组织
     * @param json 组织对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteClazzs.do")
    public Integer deleteClazzs(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Clazz> clazzs = JsonUtil.parseList(json, Clazz.class);
        return service.deleteClazzs(clazzs);
    }

    /**
     * 添加一个组织
     * @param json 组织对象的json
     * @return 成功标志1
     */
    @RequestMapping("addClazz.do")
    public Integer addClazz(String json){
        Clazz clazz = JsonUtil.parseObject(json, Clazz.class);
        return service.addClazz(clazz);
    }

    /**
     * 修改一个组织
     * @param json 组织对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateClazz.do")
    public Integer updateClazz(String json){
        Clazz clazz = JsonUtil.parseObject(json, Clazz.class);
        return service.updateClazz(clazz);
    }

    /**
     * 获取组织总数
     * @return 组织总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getAmount();
    }

    /**
     * 搜索组织
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"cname": 组织名, "mid": 专业id}
     * @return 组织信息
     */
    @RequestMapping("searchClazzs.do")
    public PageResult searchClazzs(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Clazz> clazzes = service.searchClazzs(page, limit, searchParam);
        //返回结果
        return PageResult.success(count, clazzes);
    }
}
