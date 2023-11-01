package com.xuchao.love.service.impl;

import com.xuchao.love.pojo.User;
import com.xuchao.love.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-14 16:17
 */
@Service
public class userServiceImpl implements UserService {
    @Autowired
    private com.xuchao.love.mapper.UserMapper userMapper;

    @Override
    public List<User> select(){
        List<User> tem = userMapper.select();
        return tem;
    }

    @Override
    public User selectCredit(String name) {
        User tem = userMapper.selectCredit(name);
        return tem;
    }

    @Override
    public String addCredit(Integer id) {
        try {
            userMapper.addCredit(id);
            return "添加成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加成失败";
        }
    }

    @Override
    public String requireUser(User user) {
        try {
            userMapper.requireUser(user);
            return "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
    }

    @Override
    public String selectImage(String name) {
        try {
            String url = userMapper.selectImage(name);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return "查询失败";
        }
    }

    @Override
    public User selectUser(Integer id) {
        try {
            User res = userMapper.selectUser(id);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User login(User user) {
        try {
            User res = userMapper.login(user);
            System.out.println(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String adduser(User user) {
        try {
            if(user.getSignPassword().equals(userMapper.signPassword())){
                userMapper.addUser(user);
                userMapper.detailAddUser(user);
                return "添加成功！";
            }
            else return "注册密钥错误";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }
    }

    @Override
    public String deleteUser(Integer id) {
        try {
            userMapper.deleteUser(id);
            return "删除成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

    @Override
    public void insertRemind(Integer id) {
        try {
            userMapper.insertRemind(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeRemind(Integer id) {
        try {
            userMapper.closeRemind(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeRemind(Integer operateUser, String time) {
        try {
            userMapper.changeRemind(operateUser,time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String RequireSignPassword(String password) {
        try {
            userMapper.RequireSignPassword(password);
            return "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败！";
        }
    }

    @Override
    public String signPassword() {
        try {
            String res = userMapper.signPassword();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getWechatNoticeKey() {
        try {
            String res = userMapper.getWechatNoticeKey();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
