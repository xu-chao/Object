package com.xuchao.love.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuchao
 * @create 2023-10-22 21:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BroadCast {
    private int broadCastId;
    private String broadCastText;

}
