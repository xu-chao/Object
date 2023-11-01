package com.xuchao.love.controller;

import com.xuchao.love.anno.Log;
import com.xuchao.love.anno.LimitLog;
import com.xuchao.love.pojo.Result;
import com.xuchao.love.pojo.User;
import com.xuchao.love.service.UserService;
import com.xuchao.love.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-12 14:03
 */
//输出日志文件
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UserService userService;


    @GetMapping("user")
    public Result selectUser() {
        List<User> tem = userService.select();
        for (User i : tem) {
            System.out.println(i);
        }
        log.info("查询成功");
        return Result.success(tem);
    }

    @LimitLog
    @GetMapping("selectUser")
    public Result selectUser(Integer id ) {
        try {
            User tem = userService.selectUser(id);
            log.info("查询成功");
            return Result.success(tem);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("selectCredit")
    public Result selectCredit(@RequestParam("name") String name) {
        User a = userService.selectCredit(name);
        log.info("查询成功");
        return Result.success(a);
    }

    @Log
    @RequestMapping("increaseCredit")
    public Result increaseCredit(@RequestParam("id") Integer id) {
        userService.addCredit(id);
        log.info("添加成功");
        return Result.success("添加成功");
    }

    @Log
    @RequestMapping("requireUser")
    public Result requireUser(@RequestBody User user) {
        userService.requireUser(user);
        log.info("修改成功");
        return Result.success("修改成功");
    }

    @RequestMapping("imageUser")
    public Result selectImage(@RequestParam("name") String name) {
        String url = userService.selectImage(name);
        log.info("查询成功");
        return Result.success(url);
    }

    @GetMapping("RequireSignPassword")
    public Result RequireSignPassword(@RequestParam("password") String password){
        String res = userService.RequireSignPassword(password);
        return Result.success(res);
    }

    @GetMapping("signPassword")
    public Result signPassword(){
        String res = userService.signPassword();
        return Result.success(res);
    }

    @Log
    @PostMapping ("addUser")
    public Result addUser(@RequestBody User user) {
        String url = userService.adduser(user);
        log.info("添加成功");
        return Result.success(url);
    }
    @Log
    @PutMapping ("deleteUser")
    public Result deleteUser(@RequestParam("id") Integer id) {
        String jwt = httpServletRequest.getHeader("Authorization");
        Integer operateUser = null;
        if(jwt != null){
            jwt = jwt.substring(7);
            Claims claims = JwtUtils.parseJWT(jwt);
            //登陆人ID
            operateUser = (Integer) claims.get("id");
        }
        if(operateUser == id){
            String url = userService.deleteUser(id);
            log.info("删除成功");
            return Result.success(url);
        }
        else return Result.error("你不能删除别的用户！");
    }
}
