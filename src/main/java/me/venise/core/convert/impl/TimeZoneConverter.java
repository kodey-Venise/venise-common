package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.util.TimeZone;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:22
 */
public class TimeZoneConverter extends AbstractConverter<TimeZone> {
    private static final long serialVersionUID = 1L;

    @Override
    protected TimeZone convertInternal(Object value) {
        return TimeZone.getTimeZone(convertToStr(value));
    }

}