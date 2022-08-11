package me.venise.core.convert.impl;

import me.venise.core.convert.AbstractConverter;
import me.venise.core.map.MapUtil;
import me.venise.core.util.ObjectUtil;

import java.util.Map;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 11:25
 */
public class StackTraceElementConverter extends AbstractConverter<StackTraceElement> {
    private static final long serialVersionUID = 1L;

    @Override
    protected StackTraceElement convertInternal(Object value) {
        if (value instanceof Map) {
            final Map<?, ?> map = (Map<?, ?>) value;

            final String declaringClass = MapUtil.getStr(map, "className");
            final String methodName = MapUtil.getStr(map, "methodName");
            final String fileName = MapUtil.getStr(map, "fileName");
            final Integer lineNumber = MapUtil.getInt(map, "lineNumber");

            return new StackTraceElement(declaringClass, methodName, fileName, ObjectUtil.defaultIfNull(lineNumber, 0));
        }
        return null;
    }

}
