package com.xuchao.love.service;

import com.xuchao.love.pojo.User;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-14 16:20
 */
public interface UserService {
    public List<User> select();

    public User selectCredit(String name);

    public String addCredit(Integer id);

    public String requireUser(User user);

    public String selectImage(String name);

    public User selectUser(Integer id);

    public User login(User user);

    public String adduser(User user);

    public String deleteUser(Integer id);

    public void insertRemind(Integer id);

    public void closeRemind(Integer id);

    public void changeRemind(Integer operateUser, String time);

    public String RequireSignPassword(String password);

    public String signPassword();

    public String getWechatNoticeKey();
}
