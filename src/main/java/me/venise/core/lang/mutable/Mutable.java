package me.venise.core.lang.mutable;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 14:03
 */
public interface Mutable<T> {

    /**
     * 获得原始值
     * @return 原始值
     */
    T get();

    /**
     * 设置值
     * @param value 值
     */
    void set(T value);

}