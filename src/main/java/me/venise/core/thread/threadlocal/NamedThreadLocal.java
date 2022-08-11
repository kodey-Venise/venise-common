package me.venise.core.thread.threadlocal;

/**
 * 带有Name标识的 ThreadLocal，调用toString返回name
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 15:35
 */
public class NamedThreadLocal<T> extends ThreadLocal<T> {

    private final String name;

    /**
     * 构造
     *
     * @param name 名字
     */
    public NamedThreadLocal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}