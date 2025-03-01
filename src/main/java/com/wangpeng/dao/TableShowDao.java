package com.wangpeng.dao;

import com.wangpeng.pojo.CourseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableShowDao {

    // 联合查询，将开档期、课程表表、组织表、教师表、摄影室表连接起来，筛选需要的信息
    List<CourseDetail> selectCourseDetail(@Param("year")String year, @Param("term")String term, @Param("cid")int cid);
}
