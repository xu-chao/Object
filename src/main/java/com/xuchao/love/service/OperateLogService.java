package com.xuchao.love.service;

import com.xuchao.love.pojo.SendDayMessage;

/**
 * @author xuchao
 * @create 2023-10-19 19:26
 */
public interface OperateLogService {

    public SendDayMessage selectMessage(Integer id);

    public SendDayMessage selectAllMessage(Integer id);

    public void deleteMessage(int nameId);
}
