package me.venise.core.clone;

/**
 * 克隆支持接口
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/22 16:02
 */
public interface Cloneable<T> extends java.lang.Cloneable {

    /**
     * 克隆当前对象，浅复制
     * @return
     */
    T clone();
}
