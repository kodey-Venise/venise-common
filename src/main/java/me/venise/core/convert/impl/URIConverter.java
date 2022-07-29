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
public class URIConverter extends AbstractConverter<URI> {
    private static final long serialVersionUID = 1L;

    @Override
    protected URI convertInternal(Object value) {
        try {
            if(value instanceof File){
                return ((File)value).toURI();
            }

            if(value instanceof URL){
                return ((URL)value).toURI();
            }
            return new URI(convertToStr(value));
        } catch (Exception e) {
            // Ignore Exception
        }
        return null;
    }

}