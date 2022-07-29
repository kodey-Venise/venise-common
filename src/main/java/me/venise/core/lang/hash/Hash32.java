package me.venise.core.lang.hash;

/**
 *
 * Hash计算接口
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 15:38
 */
public interface Hash32<T> {
    /**
     * 计算Hash值
     *
     * @param t 对象
     * @return hash
     */
    int hash32(T t);
}