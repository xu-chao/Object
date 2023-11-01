package com.xuchao.love.service;

import com.xuchao.love.pojo.Room;
import com.xuchao.love.pojo.Task;

/**
 * @author xuchao
 * @create 2023-10-19 16:15
 */
public interface RemindService {
    public Task remindTask(Integer id);

    public Room remindRoome(Integer id);
}
