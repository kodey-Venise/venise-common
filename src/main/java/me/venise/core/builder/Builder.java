package me.venise.core.builder;

import java.io.Serializable;

/**
 * 建造者模式接口定义
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 15:28
 */
public interface Builder<T> extends Serializable {
    /**
     * 构建
     *
     * @return 被构建的对象
     */
    T build();
}
