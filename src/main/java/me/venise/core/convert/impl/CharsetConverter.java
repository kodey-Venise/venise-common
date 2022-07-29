package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:23
 */
public class CharsetConverter extends AbstractConverter<Charset> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Charset convertInternal(Object value) {
        return CharsetUtil.charset(convertToStr(value));
    }

}
