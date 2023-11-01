package com.xuchao.love.mapper;

import com.xuchao.love.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-24 20:23
 */
@Mapper
public interface RoomMapper {
    public List<Room> selectNoRoom(String name);

    public List<Room> selectYesRoom(String name);

    public Integer addRoom(Room room);

    public void deleteRoom(Integer id);

    public Integer idSelectRoom(Integer id);

    public Integer selectId();

    public void reduceRoom(Integer id);

    @Select("select produceId, founderId, produceName, produceText, " +
            "produceImage, produceNum, checkProduce, checkLove, " +
            "useName, updateTime, registerTime from roomtable " +
            "where produceId = #{id}")
    public Room idRoom(Integer id);


    public void updateLoveRoom(Integer id);

    @Update("UPDATE detailusertable " +
            "set allReduceRoom = allReduceRoom + 1 , dayReduceRoom = dayReduceRoom + 1 " +
            "where userId = #{operateUser}")
    public void updateDetailReduceRoom(Integer operateUser);
}
