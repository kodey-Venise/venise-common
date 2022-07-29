package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.convert.ConverterRegistry;
import me.venise.core.util.TypeUtil;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:15
 */
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
    private static final long serialVersionUID = 1L;

    @Override
    protected AtomicReference<?> convertInternal(Object value) {

        //尝试将值转换为Reference泛型的类型
        Object targetValue = null;
        final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
        if(false == TypeUtil.isUnknown(paramType)){
            targetValue = ConverterRegistry.getInstance().convert(paramType, value);
        }
        if(null == targetValue){
            targetValue = value;
        }

        return new AtomicReference<>(targetValue);
    }

}