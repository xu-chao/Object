package com.xuchao.love.service;

import com.xuchao.love.pojo.Produce;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-23 11:15
 */
public interface ProduceService {
    public List<Produce> nameSelectProduce(String name);

    public List<Produce> selectProduce();

    public String updateNum(Integer produceId);

    public String deleteProduce(Integer produceId);

    public Integer addProduce(Produce produce);

    public Produce idSelectProduce(Integer id);

    public String updateLoveProduce(Integer id);


    public void updateDetailBuyProduce(int nameId);

    public void updateDetailAddProduce(Integer operateUser);
}
