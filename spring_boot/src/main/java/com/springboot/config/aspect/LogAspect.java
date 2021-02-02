package com.springboot.config.aspect;

import java.lang.annotation.*;

/**
 * 拥有该注解，可以在调用方法前后输出日志。在切面中进行配置的。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface LogAspect {
}
