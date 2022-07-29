package me.venise.core.bean;

import me.venise.core.exceptions.ExceptionUtil;
import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:33
 */
public class BeanException extends RuntimeException{
    private static final long serialVersionUID = -8096998667745023423L;

    public BeanException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public BeanException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BeanException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}