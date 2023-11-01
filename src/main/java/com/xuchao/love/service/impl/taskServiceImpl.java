package com.xuchao.love.service.impl;

import com.xuchao.love.mapper.TaskMapper;
import com.xuchao.love.pojo.Task;
import com.xuchao.love.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-14 16:17
 */
@Service
public class taskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> selectCheckTask(Integer id, String taskName) {
        List<Task> res = taskMapper.selectCheckTask(id,taskName);
        return res;
    }

    @Override
    public Integer addTask(Task task) {
        try {
            taskMapper.addTask(task);
            Integer res = task.getTaskId();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteTask(Integer id) {
        try {
            taskMapper.deleteTask(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

    @Override
    public String completedTask(Integer id) {
        try {
            taskMapper.completedTask(id);
            taskMapper.updateUserCredit(id);
            taskMapper.updateDetailCredit(id);
            try {
                taskMapper.updateDetailTask(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "成功完成任务，你真棒！";
        } catch (Exception e) {
            e.printStackTrace();
            return "完成任务失败";
        }

    }

    @Override
    public Task selectTask(Integer id) {
        try {
            Task res = taskMapper.selectTask(id);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateLoveTask(Integer id) {
        try {
            taskMapper.updateLoveTask(id);
            return "收藏成功";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void allAddTask(Integer operateUser) {
        try {
            taskMapper.allAddTask(operateUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
