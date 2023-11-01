package com.xuchao.love.service.impl;

import com.xuchao.love.mapper.RoomMapper;
import com.xuchao.love.pojo.Room;
import com.xuchao.love.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-24 20:24
 */
@Service
public class roomServiceImpl implements RoomService {

    @Autowired
    public RoomMapper roomMapper;

    @Override
    public Room idRoom(Integer id) {
        try {
            Room res = roomMapper.idRoom(id);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer idSelectRoom(Integer id) {
        try {
            Integer res = roomMapper.idSelectRoom(id);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Room> nameYesSelectRoom(String name) {
        try {
            List<Room> res = roomMapper.selectYesRoom(name);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Room> nameNoSelectRoom(String name) {
        List<Room> res = roomMapper.selectNoRoom(name);
        return res;
    }

    @Override
    public Integer addRoom(Room room) {
        try {
            roomMapper.addRoom(room);
            Integer res = room.getProduceId();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteRoom(Integer id) {
        try {
            roomMapper.deleteRoom(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "删除失败";
    }

    @Override
    public Integer selectId() {
        try {
            Integer res = roomMapper.selectId();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String reduceRoom(Integer id) {
        try {
            roomMapper.reduceRoom(id);
            return "减少成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "减少失败";
    }

    @Override
    public String updateLoveRoom(Integer id) {
        try {
            roomMapper.updateLoveRoom(id);
            return "收藏操作成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "收藏操作失败";
    }

    @Override
    public void updateDetailReduceRoom(Integer operateUser) {
        try {
            roomMapper.updateDetailReduceRoom(operateUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
