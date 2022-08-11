package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.date.DateTime;
import me.venise.core.date.DateUtil;
import me.venise.core.util.StringUtil;

import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:11
 */
public class DateConverter extends AbstractConverter<Date> {
    private static final long serialVersionUID = 1L;

    private final Class<? extends java.util.Date> targetType;
    /** 日期格式化 */
    private String format;

    /**
     * 构造
     *
     * @param targetType 目标类型
     */
    public DateConverter(Class<? extends java.util.Date> targetType) {
        this.targetType = targetType;
    }

    /**
     * 构造
     *
     * @param targetType 目标类型
     * @param format 日期格式
     */
    public DateConverter(Class<? extends java.util.Date> targetType, String format) {
        this.targetType = targetType;
        this.format = format;
    }

    /**
     * 获取日期格式
     *
     * @return 设置日期格式
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置日期格式
     *
     * @param format 日期格式
     */
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    protected java.util.Date convertInternal(Object value) {
        if (value instanceof TemporalAccessor) {
            return wrap(DateUtil.date((TemporalAccessor) value));
        } else if (value instanceof Calendar) {
            return wrap(DateUtil.date((Calendar) value));
        } else if (value instanceof Number) {
            return wrap(((Number) value).longValue());
        } else {
            // 统一按照字符串处理
            final String valueStr = convertToStr(value);
            final Date date = StringUtil.isBlank(this.format) //
                    ? DateUtil.parse(valueStr) //
                    : DateUtil.parse(valueStr, this.format);
            if(null != date){
                return wrap(date);
            }
        }

        throw new UnsupportedOperationException(StringUtil.format("Unsupport Date type: {}", this.targetType.getName()));
    }

    /**
     * java.util.Date转为子类型
     * @param date Date
     * @return 目标类型对象
     */
    private java.util.Date wrap(java.util.Date date){
        // 返回指定类型
        if (java.util.Date.class == targetType) {
            return date;
        }
        if (DateTime.class == targetType) {
            return DateUtil.date(date);
        }
        if (java.sql.Date.class == targetType) {
            return new java.sql.Date(date.getTime());
        }
        if (java.sql.Time.class == targetType) {
            return new java.sql.Time(date.getTime());
        }
        if (java.sql.Timestamp.class == targetType) {
            return new java.sql.Timestamp(date.getTime());
        }

        throw new UnsupportedOperationException(StringUtil.format("Unsupport Date type: {}", this.targetType.getName()));
    }

    /**
     * java.util.Date转为子类型
     * @param mills Date
     * @return 目标类型对象
     */
    private java.util.Date wrap(long mills){
        // 返回指定类型
        if (java.util.Date.class == targetType) {
            return new Date(mills);
        }
        if (DateTime.class == targetType) {
            return DateUtil.date(mills);
        }
        if (java.sql.Date.class == targetType) {
            return new java.sql.Date(mills);
        }
        if (java.sql.Time.class == targetType) {
            return new java.sql.Time(mills);
        }
        if (java.sql.Timestamp.class == targetType) {
            return new java.sql.Timestamp(mills);
        }

        throw new UnsupportedOperationException(StringUtil.format("Unsupport Date type: {}", this.targetType.getName()));
    }
}
