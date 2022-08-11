package me.venise.core.comparator;

import me.venise.core.exceptions.ExceptionUtil;
import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 15:37
 */
public class ComparatorException extends RuntimeException{
    private static final long serialVersionUID = 4475602435485521971L;

    public ComparatorException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public ComparatorException(String message) {
        super(message);
    }

    public ComparatorException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public ComparatorException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ComparatorException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}
