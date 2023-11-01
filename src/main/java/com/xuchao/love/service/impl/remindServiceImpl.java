package com.xuchao.love.service.impl;

import com.xuchao.love.pojo.Room;
import com.xuchao.love.pojo.Task;
import com.xuchao.love.service.RemindService;
import com.xuchao.love.service.RoomService;
import com.xuchao.love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yangyang
 * @create 2023-10-19 16:16
 */
@Service
public class remindServiceImpl implements RemindService {
    @Autowired
    private TaskService taskService;

    @Autowired
    private RoomService roomService;

    @Override
    public Task remindTask(Integer id) {
        Task task = null;
        try {
            task = taskService.selectTask(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public Room remindRoome(Integer id) {
        Room room = null;
        try {
            room = roomService.idRoom(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }
}
