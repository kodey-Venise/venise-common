package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.StringUtil;

import java.util.Locale;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:22
 */
public class LocaleConverter extends AbstractConverter<Locale> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Locale convertInternal(Object value) {
        try {
            String str = convertToStr(value);
            if (StringUtil.isEmpty(str)) {
                return null;
            }

            final String[] items = str.split("_");
            if (items.length == 1) {
                return new Locale(items[0]);
            }
            if (items.length == 2) {
                return new Locale(items[0], items[1]);
            }
            return new Locale(items[0], items[1], items[2]);
        } catch (Exception e) {
            // Ignore Exception
        }
        return null;
    }

}