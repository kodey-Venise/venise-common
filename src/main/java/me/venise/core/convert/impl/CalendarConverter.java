package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.date.DateUtil;
import me.venise.core.util.StringUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:11
 */
public class CalendarConverter extends AbstractConverter<Calendar> {
    private static final long serialVersionUID = 1L;

    /** 日期格式化 */
    private String format;

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
    protected Calendar convertInternal(Object value) {
        // Handle Date
        if (value instanceof Date) {
            return DateUtil.calendar((Date)value);
        }

        // Handle Long
        if (value instanceof Long) {
            //此处使用自动拆装箱
            return DateUtil.calendar((Long)value);
        }

        final String valueStr = convertToStr(value);
        return DateUtil.calendar(StringUtil.isBlank(format) ? DateUtil.parse(valueStr) : DateUtil.parse(valueStr, format));
    }

}
