package com.xuchao.love.service.impl;

import com.xuchao.love.mapper.BroadCastMapper;
import com.xuchao.love.pojo.BroadCast;
import com.xuchao.love.service.BroadCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-10-22 21:21
 */
@Service
public class broadCastServiceImpl implements BroadCastService {
    @Autowired
    private BroadCastMapper broadCastMapper;
    @Override
    public List<BroadCast> findAllBroadcast() {
        List<BroadCast> res = broadCastMapper.findAllBroadcast();
        return res;
    }

    @Override
    public Integer addBroadcast(BroadCast broadCast) {
        try {
            broadCastMapper.addBroadcast(broadCast);
            return broadCast.getBroadCastId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String requireBroadcast(BroadCast broadCast) {
        try {
            broadCastMapper.requireBroadcast(broadCast);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
    }

    @Override
    public String deleteBroadcast(Integer id) {
        try {
            broadCastMapper.deleteBroadcast(id);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }
}
