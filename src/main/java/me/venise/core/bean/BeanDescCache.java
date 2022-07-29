package me.venise.core.bean;

import me.venise.core.lang.SimpleCache;
import me.venise.core.lang.func.Func;
import me.venise.core.lang.func.Functions;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 11:39
 */
public enum BeanDescCache {
    INSTANCE;

    private final SimpleCache<Class<?>, BeanDesc> bdCache = new SimpleCache<>();

    /**
     * 获得属性名和{@link BeanDesc}Map映射
     * @param beanClass Bean的类
     * @param supplier 对象不存在时创建对象的函数
     * @return 属性名和{@link BeanDesc}映射
     * @since 5.4.2
     */
    public BeanDesc getBeanDesc(Class<?> beanClass, Functions<BeanDesc> supplier){
        return bdCache.get(beanClass, supplier);
    }
}
