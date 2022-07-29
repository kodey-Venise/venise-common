package me.venise.core.collection;

import me.venise.core.lang.Assert;

import java.util.Iterator;
import java.util.function.Function;

/**
 *
 * 使用给定的转换函数，转换源Iterator为新类型的Iterator
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/28 17:00
 */
public class TransIter<F, T> implements Iterator<T> {

    private final Iterator<? extends F> backingIterator;
    private final Function<? super F, ? extends T> func;

    /**
     * 构造
     *
     * @param backingIterator 源{@link Iterator}
     * @param func            转换函数
     */
    public TransIter(Iterator<? extends F> backingIterator, Function<? super F, ? extends T> func) {
        this.backingIterator = Assert.notNull(backingIterator);
        this.func = Assert.notNull(func);
    }

    @Override
    public final boolean hasNext() {
        return backingIterator.hasNext();
    }

    @Override
    public final T next() {
        return func.apply(backingIterator.next());
    }

    @Override
    public final void remove() {
        backingIterator.remove();
    }
}
