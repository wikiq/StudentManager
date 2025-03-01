package com.wangpeng.service;

import com.wangpeng.pojo.ArrangeCourse;

import java.util.List;

public interface ArrangeCourseService {

    /**
     * 找所有的档期
     * @return
     */
    List<ArrangeCourse> findAllArrangeCourses();

    /**
     * 分页找所有档期
     * @param page
     * @param size
     * @return
     */
    List<ArrangeCourse> findArrangeCoursesByPage(int page, int size);

    /**
     * 获取档期总数
     * @return
     */
    int getArrangeCoursesCount();

    /**
     * 删除指定档期
     * @param arrangeCourses
     * @return 删除成功的数量
     */
    int deleteArrangeCourses(List<ArrangeCourse> arrangeCourses);

    /**
     * 添加一个档期
     * @param arrangeCourse
     */
    int addArrangeCourse(ArrangeCourse arrangeCourse);

    /**
     * 修改一个档期
     * @param arrangeCourse
     * @return
     */
    int updateArrangeCourse(ArrangeCourse arrangeCourse);

    /**
     * 分页找所有档期（根据oid）
     * @param page
     * @param size
     * @return
     */
    List<ArrangeCourse> findArrangeCoursesByPageByOid(int page, int size, int oid);
}
