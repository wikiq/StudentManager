package com.wangpeng.service;

import com.wangpeng.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {

    /**
     * 找所有的摄影室
     * @return
     */
    List<Room> findAllRooms();

    /**
     * 分页找所有摄影室
     * @param page
     * @param size
     * @return
     */
    List<Room> findRoomsByPage(int page, int size);

    /**
     * 获取摄影室总数
     * @return
     */
    int getRoomsCount();

    /**
     * 删除指定摄影室
     * @param rooms
     * @return 删除成功的数量
     */
    int deleteRooms(List<Room> rooms);

    /**
     * 添加一个摄影室
     * @param room
     */
    int addRoom(Room room);

    /**
     * 修改一个摄影室
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * 搜索摄影室
     * @param page
     * @param size
     * @param searchParam
     */
    List<Room> searchRooms(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
