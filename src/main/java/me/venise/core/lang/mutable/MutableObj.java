package me.venise.core.lang.mutable;

import java.io.Serializable;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 14:03
 */
public class MutableObj<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 1L;

    private T value;

    /**
     * 构造，空值
     */
    public MutableObj() {
    }

    /**
     * 构造
     *
     * @param value 值
     */
    public MutableObj(final T value) {
        this.value = value;
    }

    // -----------------------------------------------------------------------
    @Override
    public T get() {
        return this.value;
    }

    @Override
    public void set(final T value) {
        this.value = value;
    }

    // -----------------------------------------------------------------------
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            final MutableObj<?> that = (MutableObj<?>) obj;
            return this.value.equals(that.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value == null ? 0 : value.hashCode();
    }

    // -----------------------------------------------------------------------
    @Override
    public String toString() {
        return value == null ? "null" : value.toString();
    }

}