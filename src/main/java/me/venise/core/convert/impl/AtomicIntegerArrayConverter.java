package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.convert.Convert;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:15
 */
public class AtomicIntegerArrayConverter extends AbstractConverter<AtomicIntegerArray> {
    private static final long serialVersionUID = 1L;

    @Override
    protected AtomicIntegerArray convertInternal(Object value) {
        return new AtomicIntegerArray(Convert.convert(int[].class, value));
    }

}