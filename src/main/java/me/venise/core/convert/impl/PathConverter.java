package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.CharsetUtil;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:23
 */
public class PathConverter extends AbstractConverter<Path>{
    private static final long serialVersionUID = 1L;

    @Override
    protected Path convertInternal(Object value) {
        try {
            if(value instanceof URI){
                return Paths.get((URI)value);
            }

            if(value instanceof URL){
                return Paths.get(((URL)value).toURI());
            }

            if(value instanceof File){
                return ((File)value).toPath();
            }

            return Paths.get(convertToStr(value));
        } catch (Exception e) {
            // Ignore Exception
        }
        return null;
    }

}