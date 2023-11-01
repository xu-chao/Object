package com.xuchao.love.mapper;

import com.xuchao.love.pojo.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-14 10:53
 */
@Mapper
public interface TaskMapper {
    public Task selectTask(Integer id);

    public List<Task> selectCheckTask(Integer id, String taskName);

    public Integer addTask(Task tem);

    @Update("UPDATE detailusertable " +
            "set allAddTask = allAddTask + 1 , dayAddTask = dayAddTask + 1 " +
            "where userId = #{operateUser}")
    public void allAddTask(Integer operateUser);

    @Delete("DELETE FROM tasktable where taskId = #{id}")
    public void deleteTask(Integer id);

    public void completedTask(Integer id);

    public void updateUserCredit(Integer id);

    public void updateLoveTask(Integer id);

    public void updateDetailTask(Integer id);

    @Update("UPDATE detailusertable " +
            "set allCredit = allCredit + (SELECT taskCredit FROM tasktable WHERE tasktable.taskId = #{id}), " +
            "dayCredit = dayCredit + (SELECT taskCredit FROM tasktable WHERE tasktable.taskId = #{id}) " +
            "where useName = (select useName from tasktable where taskId = #{id})")
    public void updateDetailCredit(Integer id);
}
