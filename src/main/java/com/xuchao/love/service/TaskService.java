package com.xuchao.love.service;

import com.xuchao.love.pojo.Task;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-14 16:19
 */
public interface TaskService {
    public List<Task> selectCheckTask(Integer id, String taskName);

    public Integer addTask(Task tem);

    public String deleteTask(Integer id);

    public String completedTask(Integer id);

    public Task selectTask(Integer id);

    public String updateLoveTask(Integer id);

    public void allAddTask(Integer operateUser);
}
