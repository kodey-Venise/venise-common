package me.venise.core.lang;

import me.venise.core.util.ArrayUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/27 14:01
 */
public class ParameterizedTypeImpl implements ParameterizedType, Serializable {


    private static final long serialVersionUID = 8483453208311718185L;

    private final Type[] actualTypeArguments;
    private final Type ownerType;
    private final Type rawType;

    public ParameterizedTypeImpl(Type[] actualTypeArguments,Type ownerType,Type rawType){
        this.actualTypeArguments = actualTypeArguments;
        this.ownerType = ownerType;
        this.rawType = rawType;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return rawType;
    }

    @Override
    public Type getOwnerType() {
        return ownerType;
    }

    public String toString(){
        final StringBuilder buf = new StringBuilder();
        final Type useOwner = this.ownerType;
        final Class<?> raw = (Class<?>) this.rawType;
        if(useOwner == null){
            buf.append(raw.getName());
        }else {
            if(useOwner instanceof Class<?>){
                buf.append(((Class<?>)useOwner).getName());
            }else {
                buf.append(useOwner.toString());
            }
            buf.append('.').append(raw.getSimpleName());
        }
        appendAllTo(buf.append('<'),",",this.actualTypeArguments).append('>');
        return buf.toString();
    }

    private static StringBuilder appendAllTo(final StringBuilder buf,final String sep,final Type... types){
        if(ArrayUtil.isNotEmpty(types)){
            boolean isFirst = true;
            for(Type type:types){
                if(isFirst){
                    isFirst = false;
                }else {
                    buf.append(sep);
                }
                String typeStr;
                if(type instanceof Class){
                    typeStr = ((Class<?>)type).getName();
                }else {
                    typeStr = type.toString();
                }
                buf.append(typeStr);
            }
        }
        return buf;
    }
}
