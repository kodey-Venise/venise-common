package me.venise.core.date;

import me.venise.core.lang.Range;

import java.util.Date;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 14:15
 */
public class DateRange extends Range<DateTime> {
    private static final long serialVersionUID = 1L;

    /**
     * 构造，包含开始和结束日期时间
     *
     * @param start 起始日期时间
     * @param end 结束日期时间
     * @param unit 步进单位
     */
    public DateRange(Date start, Date end, final DateField unit) {
        this(start, end, unit, 1);
    }

    /**
     * 构造，包含开始和结束日期时间
     *
     * @param start 起始日期时间
     * @param end 结束日期时间
     * @param unit 步进单位
     * @param step 步进数
     */
    public DateRange(Date start, Date end, final DateField unit, final int step) {
        this(start, end, unit, step, true, true);
    }

    /**
     * 构造
     *
     * @param start 起始日期时间
     * @param end 结束日期时间
     * @param unit 步进单位
     * @param step 步进数
     * @param isIncludeStart 是否包含开始的时间
     * @param isIncludeEnd 是否包含结束的时间
     */
    public DateRange(Date start, Date end, final DateField unit, final int step, boolean isIncludeStart, boolean isIncludeEnd) {
        super(DateUtil.date(start), DateUtil.date(end), (current, end1, index) -> {
            DateTime dt = current.offsetNew(unit, step);
            if (dt.isAfter(end1)) {
                return null;
            }
            return current.offsetNew(unit, step);
        }, isIncludeStart, isIncludeEnd);
    }

}
