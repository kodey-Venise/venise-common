package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.BooleanUtil;
import me.venise.core.util.StringUtil;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 10:47
 */
public class CharacterConverter extends AbstractConverter<Character> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Character convertInternal(Object value) {
        if (value instanceof Boolean) {
            return BooleanUtil.toCharacter((Boolean) value);
        } else {
            final String valueStr = convertToStr(value);
            if (StringUtil.isNotBlank(valueStr)) {
                return valueStr.charAt(0);
            }
        }
        return null;
    }

}