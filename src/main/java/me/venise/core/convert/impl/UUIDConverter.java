package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.util.UUID;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:25
 */
public class UUIDConverter extends AbstractConverter<UUID> {
    private static final long serialVersionUID = 1L;

    @Override
    protected UUID convertInternal(Object value) {
        return UUID.fromString(convertToStr(value));
    }

}