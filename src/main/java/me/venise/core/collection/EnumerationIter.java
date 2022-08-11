package me.venise.core.collection;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * {@link Enumeration}对象转{@link Iterator}对象
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/28 16:12
 */
public class EnumerationIter<E> implements Iterator<E>, Iterable<E>, Serializable {

    private static final long serialVersionUID = -5042972392124288043L;

    private final Enumeration<E> e;

    /**
     * 构造
     * @param enumeration {@link Enumeration}对象
     */
    public EnumerationIter(Enumeration<E> enumeration) {
        this.e = enumeration;
    }

    @Override
    public boolean hasNext() {
        return e.hasMoreElements();
    }

    @Override
    public E next() {
        return e.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return this;
    }

}
