package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.util.Optional;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:26
 */
public class OptionalConverter extends AbstractConverter<Optional<?>> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Optional<?> convertInternal(Object value) {
        return Optional.ofNullable(value);
    }

}