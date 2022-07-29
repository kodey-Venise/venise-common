package me.venise.core.convert.impl;

import me.venise.core.exceptions.ExceptionUtil;
import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 10:46
 */
public class ConvertException extends RuntimeException{
    private static final long serialVersionUID = 4730597402855274362L;

    public ConvertException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public ConvertException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConvertException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}