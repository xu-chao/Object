package com.xuchao.love.service;

import com.xuchao.love.pojo.BroadCast;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-10-22 21:20
 */
public interface BroadCastService {
    public List<BroadCast> findAllBroadcast();

    public Integer addBroadcast(BroadCast broadCast);

    public String requireBroadcast(BroadCast broadCast);

    public String deleteBroadcast(Integer id);
}
