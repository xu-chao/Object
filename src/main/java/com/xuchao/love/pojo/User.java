package com.xuchao.love.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author xuchao
 * @create 2023-09-12 13:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int nameId;
    private String name;
    private String password;
    private String userText;
    private String userImage;
    private int credit;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
    private String remindTime;
    private boolean remindSwitch;
    private String remindText;
    private String displayItem;
    private String displayDay;
    private String displayLogo;
    private String displayUrl;
    private String signPassword;

}
