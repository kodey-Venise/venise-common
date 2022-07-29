package me.venise.core.lang;

/**
 * 编辑器接口，常用于对集合中的元素做统一编辑
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/22 15:57
 */
public interface Editor <T>{

    /**
     * 修改过滤后的结果
     *
     * @param t 被过滤的对象
     * @return 修改后的对象，如果被过滤返回
     */
    T edit(T t);
}
