package com.xuchao.love;

import com.xuchao.love.config.TaskSchedulerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xuchao
 */
@Import(TaskSchedulerConfig.class)
@EnableScheduling
@ServletComponentScan
@SpringBootApplication
public class LoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class, args);
    }

}
