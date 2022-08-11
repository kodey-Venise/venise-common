package me.venise.core.reflect;

import me.venise.core.lang.SimpleCache;
import me.venise.core.util.TypeUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/**
 * 泛型变量和泛型实际类型映射关系缓存
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/27 14:17
 */
public class ActualTypeMapperPool {

    private static final SimpleCache<Type, Map<Type,Type>> CACHE = new SimpleCache<>();

    public static Map<Type,Type> get(Type type){return CACHE.get(type,()->createTypeMap(type));}

    public static Type getActualType(Type type, TypeVariable typeVariable){
        final Map<Type,Type> typeMap = get(type);
        Type result = typeMap.get(typeVariable);
        while (result instanceof TypeVariable){
            result = typeMap.get(result);
        }
        return result;
    }

    public static Type[] getActualTypes(Type type,Type... typeVariables){
        final Type[] result = new Type[typeVariables.length];
        for(int i=0;i<typeVariables.length;i++){
            result[i] = (typeVariables[i] instanceof TypeVariable)
                    ?getActualType(type,(TypeVariable<?>) typeVariables[i]):typeVariables[i];
        }
        return result;
    }

    private static Map<Type,Type> createTypeMap(Type type){
        final Map<Type,Type> typeMap = new HashMap<>();
        while (null!=type){
            final ParameterizedType parameterizedType = TypeUtil.toParameterizedType(type);
            if(null==parameterizedType) break;
            final Type[] typeArguments = parameterizedType.getActualTypeArguments();
            final Class<?> rawType = (Class<?>) parameterizedType.getRawType();
            final Type[] typeParameters = rawType.getTypeParameters();
            for(int i=0;i<typeParameters.length;i++){
                typeMap.put(typeParameters[i],typeArguments[i]);
            }
            type = rawType;
        }
        return typeMap;
    }

}
