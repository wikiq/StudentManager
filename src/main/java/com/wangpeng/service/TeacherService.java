package com.wangpeng.service;

import com.wangpeng.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    /**
     * 分页找所有化妆师
     * @param page
     * @param size
     * @return
     */
    List<Teacher> findTeachersByPage(int page, int size);

    /**
     * 获取化妆师总数
     * @return
     */
    int getTeachersCount();

    /**
     * 删除指定化妆师
     * @param teachers
     * @return 删除成功的数量
     */
    int deleteTeachers(List<Teacher> teachers);

    /**
     * 添加一个化妆师
     * @param teacher
     */
    int addTeacher(Teacher teacher);

    /**
     * 修改一个化妆师
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 搜索化妆师
     * @param page
     * @param size
     * @param searchParam
     */
    List<Teacher> searchTeachers(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 找所有化妆师
     * @return
     */
    List<Teacher> findAllTeachers();

    /**
     * 通过化妆师id找化妆师
     * @param tid
     * @return
     */
    Teacher findTeacher(int tid);
}
