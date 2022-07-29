package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.util.ClassLoaderUtil;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:16
 */
public class ClassConverter extends AbstractConverter<Class<?>> {
    private static final long serialVersionUID = 1L;

    private final boolean isInitialized;

    /**
     * 构造
     */
    public ClassConverter() {
        this(true);
    }

    /**
     * 构造
     *
     * @param isInitialized 是否初始化类（调用static模块内容和初始化static属性）
     * @since 5.5.0
     */
    public ClassConverter(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    @Override
    protected Class<?> convertInternal(Object value) {
        return ClassLoaderUtil.loadClass(convertToStr(value), isInitialized);
    }

}