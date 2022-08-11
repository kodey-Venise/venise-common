package me.venise.core.date;

import me.venise.core.exceptions.ExceptionUtil;
import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 13:42
 */
public class DateException extends RuntimeException{
    private static final long serialVersionUID = 8247610319171014183L;

    public DateException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public DateException(String message) {
        super(message);
    }

    public DateException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public DateException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DateException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}