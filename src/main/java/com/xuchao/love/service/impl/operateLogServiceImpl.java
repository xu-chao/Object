package com.xuchao.love.service.impl;

import com.xuchao.love.mapper.OperateLogMapper;
import com.xuchao.love.pojo.SendDayMessage;
import com.xuchao.love.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yangyang
 * @create 2023-10-19 19:33
 */
@Service
public class operateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public SendDayMessage selectMessage(Integer id) {
        SendDayMessage res = null;
        try {
            res = operateLogMapper.selectMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public SendDayMessage selectAllMessage(Integer id) {
        SendDayMessage res = null;
        try {
            res = operateLogMapper.selectAllMessage(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void deleteMessage(int nameId) {
        try {
            operateLogMapper.deleteDayMessage(nameId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
