package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.time.Period;
import java.time.temporal.TemporalAmount;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:13
 */
public class PeriodConverter extends AbstractConverter<Period> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Period convertInternal(Object value) {
        if(value instanceof TemporalAmount){
            return Period.from((TemporalAmount) value);
        }else if(value instanceof Integer){
            return Period.ofDays((Integer) value);
        } else {
            return Period.parse(convertToStr(value));
        }
    }

}