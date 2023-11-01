package com.xuchao.love.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuchao
 * @create 2023-10-07 13:33
 */
//目标是方法
@Target(ElementType.METHOD)
//运行时进行
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
