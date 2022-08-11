package me.venise.core.lang.func;

import java.io.Serializable;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 13:18
 */
public interface Functions<R> extends Serializable {
    /**
     * 执行函数
     *
     * @return 函数执行结果
     * @throws Exception 自定义异常
     */
    R call() throws Exception;

    /**
     * 执行函数，异常包装为RuntimeException
     *
     * @return 函数执行结果
     * @since 5.3.6
     */
    default R callWithRuntimeException(){
        try {
            return call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
