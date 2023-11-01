package com.xuchao.love.mapper;

import com.xuchao.love.pojo.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xuchao
 * @create 2023-09-23 11:05
 */
@Mapper
public interface ProduceMapper {
    public List<Produce> nameSelectProduce(String name);

    public List<Produce> selectProduce();

    public void updateNum(Integer produceId);

    public void updateUserCredit(Integer produceId);

    public void deleteProduce(Integer produceId);

    public Integer addProduce(Produce produce);

    @Select("select produceId,founderId,produceName, produceText, " +
            "produceImage, produceCredit, produceNum, customer," +
            "checkLove, updateTime, registerTime from producetable " +
            "where produceId = #{id} ")
    public Produce idSelectProduce(Integer id);

    public void updateLoveProduce(Integer id);

    @Update("UPDATE detailusertable " +
            "set allBuyProduce = allBuyProduce + 1 , dayBuyProduce = dayBuyProduce + 1 " +
            "where userId = #{nameId}")
    public void updateDetailBuyProduce(Integer nameId);

    @Update("UPDATE detailusertable " +
            "set allAddProduce = allAddProduce + 1 , dayAddProduce = dayAddProduce + 1 " +
            "where userId = #{operateUser}")
    public void updateDetailAddProduce(Integer operateUser);
}
