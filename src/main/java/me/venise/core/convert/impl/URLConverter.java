package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;

import java.io.File;
import java.net.URI;
import java.net.URL;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:10
 */
public class URLConverter extends AbstractConverter<URL> {
    private static final long serialVersionUID = 1L;

    @Override
    protected URL convertInternal(Object value) {
        try {
            if(value instanceof File){
                return ((File)value).toURI().toURL();
            }

            if(value instanceof URI){
                return ((URI)value).toURL();
            }
            return new URL(convertToStr(value));
        } catch (Exception e) {
            // Ignore Exception
        }
        return null;
    }

}