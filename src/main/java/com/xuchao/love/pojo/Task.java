package com.xuchao.love.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author xuchao
 * @create 2023-09-14 10:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Task {
    private Integer taskId;
    private Integer founderId;
    private String useName;
    private String userImage;
    private String taskName;
    private String taskText;
    private Integer taskCredit;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
    private boolean checkTask;
    private boolean checkLove;
}
