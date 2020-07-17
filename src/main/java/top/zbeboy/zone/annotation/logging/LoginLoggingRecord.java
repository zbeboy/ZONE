package top.zbeboy.zone.annotation.logging;

import java.lang.annotation.*;

/**
 * Created by zbeboy on 2017/2/24.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginLoggingRecord {
    /**
     * 功能模块
     *
     * @return 功能模块
     */
    String module() default "";

    /**
     * 方法名
     *
     * @return 方法名
     */
    String methods() default "";

    /**
     * 日志描述
     *
     * @return 日志描述
     */
    String description() default "";
}