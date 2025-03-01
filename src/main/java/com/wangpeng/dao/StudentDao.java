package com.wangpeng.dao;

import com.wangpeng.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 添加租户
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 删除租户
     * @param list
     * @return
     */
    int deleteStudents(List<Student> list);

    /**
     * 修改租户
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 根据id查询租户
     * @param sid
     * @return
     */
    Student selectStudent(int sid);

    /**
     * 分页查询租户
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Student> selectStudentsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取租户数量
     * @return
     */
    int getStudentsCount();

    /**
     * 分页搜索租户
     * @param map 5个参数，begin,size,sname,snum,sclass
     * @return
     */
    List<Student> searchStudentsByLimit(Map<String,Object> map);

    /**
     * 化妆师分页搜索租户
     * @param map
     * @return
     */
    List<Student> searchStudentsByLimitByTeacher(Map<String, Object> map);

    /**
     * 获取搜索的数量
     * @param map 3个参数，sname,snum,sclass
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    /**
     * 化妆师搜索租户数量
     * @param searchParam
     * @return
     */
    int getSearchCountByTeacher(Map<String, Object> searchParam);

    /**
     * 检查登录
     * @param map 2个参数，username和password
     * @return
     */
    Student checkByUsernameAndPassword(Map<String,Object> map);

    /**
     * 化妆师获得租户数量
     * @return
     */
    int getStudentsCountByTeacher(int tid);

    /**
     * 化妆师分页查询租户
     * @param begin
     * @param size
     * @param tid
     * @return
     */
    List<Student> selectStudentsByLimitByTeacher(@Param("begin")int begin, @Param("size")int size, @Param("tid")int tid);

    /**
     * 通过oid查询租户
     * @param oid
     * @return
     */
    List<Student> selectStudentsByOid(int oid);

    /**
     * 查询租户
     * @return
     */
    List<Student> selectStudents();
}
