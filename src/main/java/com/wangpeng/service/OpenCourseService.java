package com.wangpeng.service;

import com.wangpeng.pojo.OpenCourse;
import com.wangpeng.pojo.OpenCourseAndScore;

import java.util.List;
import java.util.Map;

public interface OpenCourseService {

    /**
     * 找所有的妆前准备
     * @return
     */
    List<OpenCourse> findAllOpenCourses();

    /**
     * 分页找所有妆前准备
     * @param page
     * @param size
     * @return
     */
    List<OpenCourse> findOpenCoursesByPage(int page, int size);

    /**
     * 获取妆前准备总数
     * @return
     */
    int getOpenCoursesCount();

    /**
     * 删除指定妆前准备
     * @param openCourses
     * @return 删除成功的数量
     */
    int deleteOpenCourses(List<OpenCourse> openCourses);

    /**
     * 添加一个妆前准备
     * @param openCourse
     */
    int addOpenCourse(OpenCourse openCourse);

    /**
     * 修改一个妆前准备
     * @param openCourse
     * @return
     */
    int updateOpenCourse(OpenCourse openCourse);

    /**
     * 搜索妆前准备
     * @param page
     * @param size
     * @param searchParam
     */
    List<OpenCourse> searchOpenCourses(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 化妆师
     * @param tid
     * @return
     */
    int getOpenCoursesCountByTeacher(int tid);

    List<OpenCourse> findOpenCoursesByPageByTeacher(Integer page, Integer size, Integer tid);

    /**
     * 租户查询妆前准备
     * @param sid
     * @return
     */
    List<OpenCourseAndScore> findOpenCoursesByStudent(Integer sid);
}
