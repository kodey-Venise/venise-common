package me.venise.core.convert.impl;

import me.venise.core.collection.CollUtil;
import me.venise.core.convert.Converter;
import me.venise.core.util.ObjectUtil;
import me.venise.core.util.TypeUtil;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 10:38
 */
public class CollectionConverter implements Converter<Collection<?>> {

    /** 集合类型 */
    private final Type collectionType;
    /** 集合元素类型 */
    private final Type elementType;

    /**
     * 构造，默认集合类型使用{@link Collection}
     */
    public CollectionConverter() {
        this(Collection.class);
    }

    // ---------------------------------------------------------------------------------------------- Constractor start
    /**
     * 构造
     *
     * @param collectionType 集合类型
     */
    public CollectionConverter(Type collectionType) {
        this(collectionType, TypeUtil.getTypeArgument(collectionType));
    }

    /**
     * 构造
     *
     * @param collectionType 集合类型
     */
    public CollectionConverter(Class<?> collectionType) {
        this(collectionType, TypeUtil.getTypeArgument(collectionType));
    }

    /**
     * 构造
     *
     * @param collectionType 集合类型
     * @param elementType 集合元素类型
     */
    public CollectionConverter(Type collectionType, Type elementType) {
        this.collectionType = collectionType;
        this.elementType = elementType;
    }
    // ---------------------------------------------------------------------------------------------- Constractor end

    @Override
    public Collection<?> convert(Object value, Collection<?> defaultValue) throws IllegalArgumentException {
        final Collection<?> result = convertInternal(value);
        return ObjectUtil.defaultIfNull(result, defaultValue);
    }

    /**
     * 内部转换
     *
     * @param value 值
     * @return 转换后的集合对象
     */
    protected Collection<?> convertInternal(Object value) {
        final Collection<Object> collection = CollUtil.create(TypeUtil.getClass(this.collectionType));
        return CollUtil.addAll(collection, value, this.elementType);
    }
}
