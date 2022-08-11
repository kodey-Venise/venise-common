package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.util.Currency;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:24
 */
public class CurrencyConverter extends AbstractConverter<Currency> {
    private static final long serialVersionUID = 1L;

    @Override
    protected Currency convertInternal(Object value) {
        return Currency.getInstance(convertToStr(value));
    }

}