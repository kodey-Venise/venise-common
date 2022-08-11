package me.venise.core.thread.threadlocal;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 15:35
 */
public class NamedInheritableThreadLocal<T> extends InheritableThreadLocal<T> {

    private final String name;

    /**
     * 构造
     *
     * @param name 名字
     */
    public NamedInheritableThreadLocal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
