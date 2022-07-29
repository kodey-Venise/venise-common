package me.venise.core.clone;

/**
 * 克隆支持类，提供默认的克隆方法
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/22 16:24
 */
public class CloneSupport <T> implements Cloneable<T>{

    @SuppressWarnings("unchecked")
    @Override
    public T clone() {
        try {
            return (T)super.clone();
        }catch (CloneNotSupportedException e){
            throw new CloneRuntimeException(e);
        }
    }
}
