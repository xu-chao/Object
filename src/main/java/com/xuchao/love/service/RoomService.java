package com.xuchao.love.service;

import com.xuchao.love.pojo.Room;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-24 20:24
 */
public interface RoomService {

    public Room idRoom(Integer id);

    public Integer idSelectRoom(Integer id);

    public List<Room> nameYesSelectRoom(String name);

    public List<Room> nameNoSelectRoom(String name);

    public Integer addRoom(Room room);

    public String deleteRoom(Integer id);

    public Integer selectId();

    public String reduceRoom(Integer id);

    public String updateLoveRoom(Integer id);

    public void updateDetailReduceRoom(Integer operateUser);
}
