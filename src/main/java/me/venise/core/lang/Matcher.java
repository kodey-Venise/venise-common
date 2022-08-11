package me.venise.core.lang;

/**
 * 匹配接口
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/22 15:59
 */
public interface Matcher <T>{

    /**
     * 给定对象是否匹配
     *
     * @param t
     * @return
     */
    boolean match(T t);
}
