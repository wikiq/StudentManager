package com.wangpeng.service;

import com.wangpeng.pojo.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 分页找所有租户
     * @param page
     * @param size
     * @return
     */
    List<Student> findStudentsByPage(int page, int size);

    /**
     * 获取租户总数
     * @return
     */
    int getStudentsCount();

    /**
     * 删除指定租户
     * @param students
     * @return 删除成功的数量
     */
    int deleteStudents(List<Student> students);

    /**
     * 添加一个租户
     * @param student
     */
    int addStudent(Student student);

    /**
     * 修改一个租户
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 搜索租户
     * @param page
     * @param size
     * @param searchParam
     */
    List<Student> searchStudents(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 化妆师搜索租户
     * @param page
     * @param size
     * @param searchParam
     * @return
     */
    List<Student> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 化妆师获取搜索租户数量
     * @param searchParam
     * @return
     */
    int getSearchCountByTeacher(Map<String, Object> searchParam);

    /**
     * 化妆师获取租户数量
     * @param tid
     * @return 租户数量
     */
    int getStudentsCountByTeacher(int tid);

    /**
     * 化妆师分页查询租户
     * @param page
     * @param size
     * @param tid
     * @return
     */
    List<Student> findStudentsByPageByTeacher(Integer page, Integer size, int tid);

    /**
     * 通过oid查询租户
     * @param oid
     * @return
     */
    List<Student> findStudentsByOid(int oid);

    /**
     * 通过租户id寻找租户
     * @param sid
     * @return
     */
    Student findStudentBySid(Integer sid);

    /**
     * 导出信息
     * @param req
     * @return
     */
    String print(HttpServletRequest req);
}
