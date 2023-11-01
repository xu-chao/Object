package com.xuchao.love.mapper;

import com.xuchao.love.pojo.SendDayMessage;
import com.xuchao.love.pojo.OperateLog;
import org.apache.ibatis.annotations.*;

/**
 * @author xuchao
 */
@Mapper
public interface OperateLogMapper {
    //插入日志数据
    @Insert("insert into operate_log (operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Select("select dayCredit,dayCompleteTask,dayAddTask,dayAddProduce,dayBuyProduce,dayReduceRoom from detailusertable where userId = #{id}")
    public SendDayMessage selectMessage(Integer id);

    @Select("select allCredit as dayCredit," +
            "allCompleteTask as dayCompleteTask," +
            "allAddTask as dayAddTask," +
            "allAddProduce as dayAddProduce, " +
            "allBuyProduce as dayBuyProduce, " +
            "allReduceRoom as dayReduceRoom " +
            "from detailusertable " +
            "where userId = #{id}")
    public SendDayMessage selectAllMessage(Integer id);

    @Update("update detailusertable " +
            "set dayCredit = 0," +
            "dayCompleteTask = 0 ," +
            "dayAddTask = 0," +
            "dayAddProduce = 0," +
            "dayBuyProduce = 0," +
            "dayReduceRoom = 0 " +
            "where userId = #{nameId};")
    public void deleteDayMessage(int nameId);

}
