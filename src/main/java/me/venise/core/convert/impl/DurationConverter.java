package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.time.Duration;
import java.time.temporal.TemporalAmount;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:14
 */
public class DurationConverter extends AbstractConverter<Duration> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Duration convertInternal(Object value) {
        if(value instanceof TemporalAmount){
            return Duration.from((TemporalAmount) value);
        } else if(value instanceof Long){
            return Duration.ofMillis((Long) value);
        } else {
            return Duration.parse(convertToStr(value));
        }
    }

}