package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.BooleanUtil;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 10:47
 */
public class BooleanConverter extends AbstractConverter<Boolean> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Boolean convertInternal(Object value) {
        if (value instanceof Number) {
            // 0为false，其它数字为true
            return 0 != ((Number) value).doubleValue();
        }
        //Object不可能出现Primitive类型，故忽略
        return BooleanUtil.toBoolean(convertToStr(value));
    }

}