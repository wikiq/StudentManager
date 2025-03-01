package com.wangpeng.dao;

import com.wangpeng.pojo.CourseGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseGradeDao {
    /**
     * 添加结果
     * @param courseGrade
     * @return
     */
    int insertCourseGrade(CourseGrade courseGrade);

    /**
     * 删除结果
     * @param courseGrades
     * @return
     */
    int deleteCourseGrades(List<CourseGrade> courseGrades);

    /**
     * 修改结果
     * @param courseGrade
     * @return
     */
    int updateCourseGrade(CourseGrade courseGrade);

    /**
     * 查询所有结果
     * @return
     */
    List<CourseGrade> selectCourseGrades();

    /**
     * 根据id查询结果
     * @param id
     * @return
     */
    CourseGrade selectCourseGrade(Integer id);

    /**
     * 分页查询结果
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<CourseGrade> selectCourseGradesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取结果数量
     * @return
     */
    int getCourseGradesCount();

    /**
     * 分页搜索结果
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<CourseGrade> searchCourseGradesByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    /**
     * 根据oid和sid查询结果
     * @param oid
     * @param sid
     * @return
     */
    CourseGrade selectCourseGradeByOidAndSid(@Param("oid")int oid, @Param("sid")int sid);

    /**
     * 根据oid和sid更新结果
     * @param courseGrade
     * @return
     */
    int updateCourseGradeByOidAndSid(CourseGrade courseGrade);
}
