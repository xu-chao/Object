package com.xuchao.love.mapper;

import com.xuchao.love.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-12 14:00
 */
@Mapper
public interface UserMapper {
//  按ids查找用户
    public List<User> select();

    @Select("select nameId, name, userText, userImage, credit, " +
            "updateTime, registerTime, remindSwitch,remindTime," +
            "remindText,displayItem,displayDay,displayLogo,displayUrl from usertable " +
            "where nameId = #{id}"
    )
    public User selectUser(Integer id);

    //按用户name查找用户信息，返回credit
    public User selectCredit(String name);

    public void addCredit(Integer id);

    public void requireUser(User user);

    @Select("select userImage from usertable where name = #{name}")
    public String selectImage(String name);

    public User login(User user);

    public Integer addUser(User user);

    public void detailAddUser(User user);

    @Delete("delete from usertable where nameId = #{id}")
    public void deleteUser(Integer id);

    @Update("update usertable set remindSwitch = 1 " +
            "where nameId = #{nameId}")
    public void insertRemind(Integer nameId);

    @Update("update usertable set remindSwitch = 0 " +
            "where nameId = #{nameId}")
    public void closeRemind(Integer nameId);

    @Update("update usertable set  remindTime = #{time} where nameId = #{operateUser}")
    public void changeRemind(Integer operateUser, String time);

    @Update("update logincheck set value = #{password} where attribute = 'loginCheck' ")
    public void RequireSignPassword(String password);

    @Select("select value from logincheck where attribute = 'loginCheck' ")
    public String signPassword();

    @Select("select value from logincheck where attribute = 'wechatNoticeKey' ")
    public String getWechatNoticeKey();
}

