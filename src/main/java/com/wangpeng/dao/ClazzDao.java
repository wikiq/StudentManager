package com.wangpeng.dao;

import com.wangpeng.pojo.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClazzDao {
    /**
     * 添加组织
     * @param clazz
     * @return
     */
    int insertClazz(Clazz clazz);

    /**
     * 删除组织
     * @param clazzes
     * @return
     */
    int deleteClazzs(List<Clazz> clazzes);

    /**
     * 修改组织
     * @param clazz
     * @return
     */
    int updateClazz(Clazz clazz);

    /**
     * 查询所有组织
     * @return
     */
    List<Clazz> selectClazzs();

    /**
     * 通过教师查询所有组织
     */
    List<Clazz> getCLazzsByTeacher(int tid);

    /**
     * 查询组织
     * @param id
     * @return
     */
    Clazz selectClazz(int id);

    /**
     * 分页查询组织
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Clazz> selectClazzsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取组织数量
     * @return
     */
    int getClazzsCount();

    /**
     * 分页搜索组织
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Clazz> searchClazzsByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

}
