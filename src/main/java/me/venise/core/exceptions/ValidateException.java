package me.venise.core.exceptions;

import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 16:12
 */
public class ValidateException extends StatefulException {
    private static final long serialVersionUID = 6057602589533840889L;

    public ValidateException() {
    }

    public ValidateException(String msg) {
        super(msg);
    }

    public ValidateException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public ValidateException(Throwable throwable) {
        super(throwable);
    }

    public ValidateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ValidateException(int status, String msg) {
        super(status, msg);
    }

    public ValidateException(int status, Throwable throwable) {
        super(status, throwable);
    }

    public ValidateException(int status, String msg, Throwable throwable) {
        super(status, msg, throwable);
    }
}