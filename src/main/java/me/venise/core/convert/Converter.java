package me.venise.core.convert;

/**
 * 转换器接口，实现类型转换
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/28 11:12
 */
public interface Converter <T>{

    /**
     * 转换为指定类型
     * 如果类型确定，将读取默认的类型作为目标类型
     *
     * @param value 原始值
     * @param defaultValue 默认值
     * @return 转换后的值
     * @throws IllegalArgumentException 无法确定目标类型，且默认值为{@code null} 无法确定类型
     */
    @SuppressWarnings("unchecked")
    T convert(Object value, T defaultValue);
}
