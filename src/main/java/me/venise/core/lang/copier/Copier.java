package me.venise.core.lang.copier;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/28 15:14
 */
@FunctionalInterface
public interface Copier<T> {
    /**
     * 执行拷贝
     * @return 拷贝的目标
     */
    T copy();
}