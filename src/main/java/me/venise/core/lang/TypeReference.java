package me.venise.core.lang;

import me.venise.core.util.TypeUtil;

import java.lang.reflect.Type;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/22 17:20
 */
public abstract class TypeReference<T> implements Type {

    /**泛型参数*/
    private final Type type;

    public TypeReference(){
        this.type = TypeUtil.getTypeArgument(getClass());
    }

    public Type getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return this.type.toString();
    }
}
