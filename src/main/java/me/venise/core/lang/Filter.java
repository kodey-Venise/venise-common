package me.venise.core.lang;

/**
 * 过滤器接口
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/22 15:56
 */
public interface Filter <T>{

    /**
     * 是否接收对象
     * @param t
     * @return
     */
    boolean accept(T t);
}
