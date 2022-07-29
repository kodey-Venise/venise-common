package me.venise.core.lang;

import me.venise.core.convert.Convert;
import me.venise.core.util.NumberUtil;

import java.lang.reflect.Type;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 15:41
 */
public interface Segment<T extends Number> {

    /**
     * 获取起始位置
     *
     * @return 起始位置
     */
    T getStartIndex();

    /**
     * 获取结束位置
     *
     * @return 结束位置
     */
    T getEndIndex();

    /**
     * 片段长度，默认计算方法为abs({@link #getEndIndex()} - {@link #getEndIndex()})
     *
     * @return 片段长度
     */
    default T length(){
        final T start = Assert.notNull(getStartIndex(), "Start index must be not null!");
        final T end = Assert.notNull(getEndIndex(), "End index must be not null!");
        return Convert.convert((Type) start.getClass(), NumberUtil.sub(end, start).abs());
    }
}