package me.venise.core.lang.func;

import java.io.Serializable;

/**
 * 无参数的函数对象
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/27 14:25
 */
public interface Func<P,R> extends Serializable {

    /**
     * 执行函数
     * @return
     * @throws Exception
     */
    R call(P parameter) throws Exception;
    /**
     * 执行函数，异常包装为RuntimeException
     * @return
     */
    default R callWithRuntimeException(P parameter){
        try {
            return call(parameter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
