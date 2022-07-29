package me.venise.core.annotation;

import java.lang.annotation.*;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:37
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface Alias {

    /**
     * 别名值，即使用此注解要替换成的别名名称
     *
     * @return 别名值
     */
    String value();
}
