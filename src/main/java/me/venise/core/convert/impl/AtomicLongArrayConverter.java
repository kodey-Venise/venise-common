package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.convert.Convert;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:15
 */
public class AtomicLongArrayConverter extends AbstractConverter<AtomicLongArray> {
    private static final long serialVersionUID = 1L;

    @Override
    protected AtomicLongArray convertInternal(Object value) {
        return new AtomicLongArray(Convert.convert(long[].class, value));
    }

}