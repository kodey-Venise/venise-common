package me.venise.core.bean.copier.provider;

import me.venise.core.bean.BeanUtil;
import me.venise.core.bean.PropDesc;
import me.venise.core.bean.copier.ValueProvider;
import me.venise.core.util.StringUtil;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 13:29
 */
public class BeanValueProvider implements ValueProvider<String> {

    private final Object source;
    private final boolean ignoreError;
    final Map<String, PropDesc> sourcePdMap;

    /**
     * 构造
     *
     * @param bean        Bean
     * @param ignoreCase  是否忽略字段大小写
     * @param ignoreError 是否忽略字段值读取错误
     */
    public BeanValueProvider(Object bean, boolean ignoreCase, boolean ignoreError) {
        this.source = bean;
        this.ignoreError = ignoreError;
        sourcePdMap = BeanUtil.getBeanDesc(source.getClass()).getPropMap(ignoreCase);
    }

    @Override
    public Object value(String key, Type valueType) {
        final PropDesc sourcePd = getPropDesc(key, valueType);

        Object result = null;
        if (null != sourcePd) {
            result = sourcePd.getValue(this.source, valueType, this.ignoreError);
        }
        return result;
    }

    @Override
    public boolean containsKey(String key) {
        final PropDesc sourcePd = getPropDesc(key, null);

        // 字段描述不存在或忽略读的情况下，表示不存在
        return null != sourcePd && sourcePd.isReadable(false);
    }

    /**
     * 获得属性描述
     *
     * @param key       字段名
     * @param valueType 值类型，用于判断是否为Boolean，可以为null
     * @return 属性描述
     */
    private PropDesc getPropDesc(String key, Type valueType) {
        PropDesc sourcePd = sourcePdMap.get(key);
        if (null == sourcePd && (null == valueType || Boolean.class == valueType || boolean.class == valueType)) {
            //boolean类型字段字段名支持两种方式
            sourcePd = sourcePdMap.get(StringUtil.upperFirstAndAddPre(key, "is"));
        }

        return sourcePd;
    }
}
