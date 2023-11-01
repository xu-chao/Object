package com.xuchao.love.service.impl;

import com.xuchao.love.mapper.ProduceMapper;
import com.xuchao.love.pojo.Produce;
import com.xuchao.love.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangyang
 * @create 2023-09-23 11:18
 */
@Service
public class produceServiceImpl implements ProduceService {
    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public List<Produce> nameSelectProduce(String name) {
        List<Produce> res = produceMapper.nameSelectProduce(name);
        return res;
    }

    @Override
    public List<Produce> selectProduce() {
        List<Produce> res = produceMapper.selectProduce();
        return res;
    }

    @Override
    public String updateNum(Integer produceId) {
        try {
            produceMapper.updateNum(produceId);
            produceMapper.updateUserCredit(produceId);
            return "成功购买商品！";
        } catch (Exception e) {
            e.printStackTrace();
            return "购买商品失败";
        }
    }

    @Override
    public String deleteProduce(Integer produceId) {
        try {
            produceMapper.deleteProduce(produceId);
            return "成功删除商品！";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除商品失败";
        }
    }

    @Override
    public Integer addProduce(Produce produce) {
        try {
            produceMapper.addProduce(produce);
            Integer res = produce.getProduceId();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Produce idSelectProduce(Integer id) {
        try {
            Produce res = produceMapper.idSelectProduce(id);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String updateLoveProduce(Integer id) {
        try {
            produceMapper.updateLoveProduce(id);
            return "收藏操作成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "收藏操作失败";
    }

    @Override
    public void updateDetailBuyProduce(int nameId) {
        try {
            produceMapper.updateDetailBuyProduce(nameId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateDetailAddProduce(Integer operateUser) {
        try {
            produceMapper.updateDetailAddProduce(operateUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
