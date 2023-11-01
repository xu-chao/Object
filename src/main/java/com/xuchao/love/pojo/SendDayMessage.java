package com.xuchao.love.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Yangyang
 * @create 2023-10-20 13:58
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SendDayMessage {
    private Integer dayCredit;
    private Integer dayCompleteTask;
    private Integer dayAddTask;
    private Integer dayAddProduce;
    private Integer dayBuyProduce;
    private Integer dayReduceRoom;
}
