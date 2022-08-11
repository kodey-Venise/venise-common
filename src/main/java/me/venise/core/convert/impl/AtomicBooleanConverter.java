package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.BooleanUtil;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 10:48
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {
    private static final long serialVersionUID = 1L;

    @Override
    protected AtomicBoolean convertInternal(Object value) {
        if (value instanceof Boolean) {
            return new AtomicBoolean((Boolean) value);
        }
        final String valueStr = convertToStr(value);
        return new AtomicBoolean(BooleanUtil.toBoolean(valueStr));
    }

}