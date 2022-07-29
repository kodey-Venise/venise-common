package me.venise.core.lang;

/**
 * 责任链接口
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 10:58
 */
public interface Chain<E, T> extends Iterable<E>{
    /**
     * 加入责任链
     * @param element 责任链新的环节元素
     * @return this
     */
    T addChain(E element);
}

