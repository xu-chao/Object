package com.xuchao.love.controller;

import com.xuchao.love.pojo.Result;
import com.xuchao.love.pojo.BroadCast;
import com.xuchao.love.service.BroadCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-10-22 21:21
 */
@RestController()
@RequestMapping("/api")
public class BroadCastController {
    @Autowired
    private BroadCastService broadCastService;
    @GetMapping("/findAllBroadcast")
    public Result findAllBroadcast(){
        List<BroadCast> res = broadCastService.findAllBroadcast();
        return Result.success(res);
    }

    @PostMapping("/addBroadcast")
    public Result addBroadcast(@RequestBody BroadCast broadCast){
        try {
            Integer res = broadCastService.addBroadcast(broadCast);
            return Result.success(res);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null);
        }
    }

    @PostMapping ("requireBroadcast")
    public Result requireBroadcast(@RequestBody BroadCast broadCast){
        try {
            String res = broadCastService.requireBroadcast(broadCast);
            return Result.success(res);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    @GetMapping("deleteBroadcast")
    public Result deleteBroadcast(@RequestParam("id") Integer id){
        try {
            String res = broadCastService.deleteBroadcast(id);
            return Result.success(res);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }
}
