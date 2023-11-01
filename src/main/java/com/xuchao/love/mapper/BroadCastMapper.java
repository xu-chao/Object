package com.xuchao.love.mapper;

import com.xuchao.love.pojo.BroadCast;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-10-22 21:21
 */
@Mapper
public interface BroadCastMapper {
    @Select("select broadCastId,broadCastText from homebroadcast ")
    public List<BroadCast> findAllBroadcast();

    @Insert("insert into homebroadcast (broadCastText) values (#{broadCastText})")
    @SelectKey(statement = "SELECT last_insert_id() as id ", before = false, resultType = Integer.class, keyProperty = "broadCastId")
    public Integer addBroadcast(BroadCast broadCast);

    @Update("update homebroadcast set broadCastText = #{broadCastText} where broadCastId = #{broadCastId}")
    public void requireBroadcast(BroadCast broadCast);

    @Delete("delete from homebroadcast where broadCastId = #{id}")
    public void deleteBroadcast(Integer id);
}
