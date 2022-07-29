package me.venise.core.lang;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 15:41
 */
public class DefaultSegment<T extends Number> implements Segment<T> {

    protected T startIndex;
    protected T endIndex;

    /**
     * 构造
     * @param startIndex 起始位置
     * @param endIndex 结束位置
     */
    public DefaultSegment(T startIndex, T endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public T getStartIndex() {
        return this.startIndex;
    }

    @Override
    public T getEndIndex() {
        return this.endIndex;
    }
}
