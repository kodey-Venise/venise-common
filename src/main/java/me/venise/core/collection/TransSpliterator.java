package me.venise.core.collection;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 使用给定的转换函数，转换源{@link Spliterator}为新类型的{@link Spliterator}
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/28 18:03
 */
public class TransSpliterator<F, T> implements Spliterator<T> {
    private final Spliterator<F> fromSpliterator;
    private final Function<? super F, ? extends T> function;

    public TransSpliterator(Spliterator<F> fromSpliterator, Function<? super F, ? extends T> function) {
        this.fromSpliterator = fromSpliterator;
        this.function = function;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        return fromSpliterator.tryAdvance(
                fromElement -> action.accept(function.apply(fromElement)));
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        fromSpliterator.forEachRemaining(fromElement -> action.accept(function.apply(fromElement)));
    }

    @Override
    public Spliterator<T> trySplit() {
        Spliterator<F> fromSplit = fromSpliterator.trySplit();
        return (fromSplit != null) ? new TransSpliterator<>(fromSplit, function) : null;
    }

    @Override
    public long estimateSize() {
        return fromSpliterator.estimateSize();
    }

    @Override
    public int characteristics() {
        return fromSpliterator.characteristics()
                & ~(Spliterator.DISTINCT | Spliterator.NONNULL | Spliterator.SORTED);
    }
}
