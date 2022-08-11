package me.venise.core.util;


import me.venise.core.collection.CollUtil;
import me.venise.core.collection.CollectionUtil;
import me.venise.core.collection.IterUtil;
import me.venise.core.comparator.CompareUtil;
import me.venise.core.exceptions.UtilException;
import me.venise.core.lang.Assert;
import me.venise.core.lang.Editor;
import me.venise.core.lang.Filter;
import me.venise.core.lang.Matcher;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/27 11:15
 */
public class ArrayUtil extends PrimitiveArrayUtil{

    /**
     * 数组是否为空
     * @param array 数组
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> boolean isEmpty(T[] array){return array==null||array.length ==0;}

    /**
     * 如果给定数组为空，返回默认数组
     * @param array 数组
     * @param defaultArray 默认数组
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> T[] defaultIfEmpty(T[] array,T[] defaultArray){return isEmpty(array)? defaultArray:array;}

    /**
     * 数组是否为空
     * 此方法会匹配单一对象，如果此对象为{@code null} 则返回true
     * 如果此对象为非数组，理解为此对象为数组中的第一个元素，则返回fasle
     * 如果此对象为数组对象，数组长度大于0情况下返回false,则返回true
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(Object array){
        if(array!=null){
            if(isArray(array)){
                return 0== Array.getLength(array);
            }
            return false;
        }
        return true;
    }

    /**
     * 数组是否为非空
     *
     * @param array 数组
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> boolean isNotEmpty(T[] array){return !isEmpty(array);}

    /**
     * 数组是否为空
     * 此方法会匹配单一对象,如果此对象为{@code null} 则返回false
     * 如果此对象为非数组，理解为此对象为数组的第一个元素,则返回true
     * 如果此对象为数组对象，数组长度大于0情况下返回true，否则返回false
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object array){return false==isEmpty(array);}

    /**
     * 判断是否包含 null 元素
     * @param array 被检查的数组
     * @param <T> 数组元数据类型
     * @return
     */
    public static <T> boolean hasNull(T...array){
        if(isNotEmpty(array)){
            for(T element:array){
                if(null==element){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 多个字段是否全为null
     * @param array
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean isAllNull(T...array){return null==firstNonNull(array);}

    /**
     * 返回数组中第一个非空元素
     * @param array 数组
     * @param <T> 数组元素类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T firstNonNull(T...array){return firstMatch(Objects::nonNull,array);}

    /**
     * 返回数组中第一个匹配规则的值
     * @param matcher 匹配接口，实现此接口自定义匹配规则
     * @param array 数组
     * @param <T> 数组元素类型
     * @return 非空元素，如果不存在封控元素或者数组为空，返回 {@code null}
     */
    public static <T>T firstMatch(Matcher<T> matcher,T...array){
        if(isNotEmpty(array)){
            for(final T val:array){
                if(matcher.match(val)){
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * 创建空数组
     * @param componentType 元素类型
     * @param newSize 大小
     * @param <T>数组，元素类型
     * @return
     */
    public static <T> T[] newArray(Class<?> componentType,int newSize){
        return (T[]) Array.newInstance(componentType,newSize);
    }

    /**
     * 创建空数组
     * @param newSize 长度大小
     * @return
     */
    public static Object[] newArray(int newSize){return new Object[newSize];}

    /**
     * 获取数组对象的元素类型
     * @param array
     * @return
     */
    public static Class<?> getComponentType(Object array){
        return null == array ? null: array.getClass().getComponentType();
    }

    /**
     * 获取数组对象的元素类型
     * @param array
     * @return
     */
    public static Class<?> getComponentType(Class<?> array){
        return null == array ? null: array.getClass().getComponentType();
    }

    /**
     * 根据数组元素类型，获取数组的类型
     * 方法时通过创建一个空数组从而获取其类型
     *
     * @param componentType 数组元素类型
     * @return 数组类型
     */
    public static Class<?> getArrayType(Class<?> componentType){return Array.newInstance(componentType,0).getClass();}

    /**
     * 强制转换数组类型
     * 强制转换数组的前提时数组元素类型可被强制转换
     * 强制转换后会生成新的数组
     * @param type
     * @param arrayObj
     * @return
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public static Object[] cast(Class<?> type,Object arrayObj)throws NullPointerException,IllegalArgumentException{
        if(null==arrayObj) throw new NullPointerException("Argument [arrayObj] is null !");
        if(!arrayObj.getClass().isArray()) throw new IllegalArgumentException("Argument [arrayObj] is not array !");
        if(null == type) return (Object[]) arrayObj;

        final Class<?> componentType = type.isArray()? type.getComponentType():type;
        final Object[] array = (Object[]) arrayObj;
        final Object[] result = ArrayUtil.newArray(componentType,array.length);
        System.arraycopy(array,0,result,0,array.length);
        return result;
    }

    /**
     * 将新元素添加到已有数组中，添加新元素会生成新的数组，不影响原有数组
     * @param buffer 原始数组
     * @param newElements 新元素
     * @param <T> 数组元素类型
     * @return
     */
    @SafeVarargs
    public static <T> T[] append(T[] buffer,T...newElements){
        if(isEmpty(buffer)) return newElements;
        return insert(buffer,buffer.length,newElements);
    }

    /**
     * 将新元素添加到已有数组中，添加新元素会生成新的数组，不影响原有数组
     * @param array 原始数组
     * @param newElements 新元素
     * @param <T> 数组元素类型
     * @return
     */
    @SafeVarargs
    public static <T> Object append(Object array,T...newElements){
        if(isEmpty(array)) return newElements;
        return insert(array,length(array),newElements);
    }

    /**
     * 将元素值设置为数组的某个位置，当给定的index大于数组长度，则最佳
     *
     * @param buffer 原始数组
     * @param index 位置，大于长度则追加，否则替换
     * @param value 替换或插入的值
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> T[] setOrAppend(T[] buffer,int index,T value){
        if(index< buffer.length){
            Array.set(buffer,index,value);
            return buffer;
        }else {
           return append(buffer,value);
        }
    }

    /**
     * 将元素值设置为数组的某个位置，当给定的index大于数组长度，则最佳
     *
     * @param buffer 原始数组
     * @param index 位置，大于长度则追加，否则替换
     * @param value 替换或插入的值
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> Object setOrAppend(Object buffer,int index,T value){
        if(index< length(buffer)){
            Array.set(buffer,index,value);
            return buffer;
        }else {
            return append(buffer,value);
        }
    }

    /**
     * 将新元素插入到原始数组中的某个位置
     * 添加新元素会新城新的数组，不改变原始数组
     * 如果插入的位置为负数，从原数组从后往前计算，若大于原数组长度，则空白处用Null填充
     * @param buffer
     * @param index
     * @param newElements
     * @param <T>
     * @return
     */
    public static <T> T[] insert(T[] buffer,int index,T...newElements){
        return (T[])insert((Object)buffer,index,newElements);
    }

    /**
     * 将新元素插入到原始数组中的某个位置
     * 添加新元素会新城新的数组，不改变原始数组
     * 如果插入的位置为负数，从原数组从后往前计算，若大于原数组长度，则空白处用Null填充
     * @param array
     * @param index
     * @param newElements
     * @param <T>
     * @return
     */
    public static <T> Object insert(Object array,int index,T...newElements){
        if(isEmpty(newElements)) return array;
        if(isEmpty(array)) return newElements;
        final int len = length(array);
        if(index<0) index = (index%len) +len;

        final T[] result = newArray(array.getClass().getComponentType(),Math.max(len,index)+newElements.length);
        System.arraycopy(array,0,result,0,Math.min(len,index));
        System.arraycopy(newElements,0,result,index,newElements.length);
        if (index<len) System.arraycopy(array,index,result,index+newElements.length,len-index);
        return result;
    }

    /**
     * 生成一个新的重新设置大小的数组
     * 调整大小后靠白原数组的数组到新数组下。扩大则站位站N个位置，缩小则截断
     *
     * @param data 原数组
     * @param newSize 新数组的大小
     * @param componentType 数组元素类型
     * @param <T> 数组元素类型
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] data,int newSize,Class<?> componentType){
        if(newSize<0) return data;
        final T[] newArray = newArray(componentType,newSize);
        if(newSize>0 && isNotEmpty(data)) System.arraycopy(data,0,newArray,0,Math.min(data.length,newSize));
        return newArray;
    }

    /**
     * 生成一个新的重新设置大小的数组
     * 调整大小后靠白原数组的数组到新数组下。扩大则站位站N个位置，缩小则截断
     *
     * @param array 原数组
     * @param newSize 新数组的大小
     * @return 调整后的新数组
     */
    public static  Object resize(Object array,int newSize){
        if(newSize<0) return array;
        if(null==array) return null;

        final int length = length(array);
        final Object newArray = Array.newInstance(array.getClass().getComponentType(),newSize);
        if(newSize >0 && isNotEmpty(array)) System.arraycopy(array,0,newArray,0,Math.min(length,newSize));
        return newArray;
    }


    /**
     * 生成一个新的重新设置大小的数组
     * 调整大小后靠白原数组的数组到新数组下。扩大则站位站N个位置，缩小则截断
     *
     * @param buffer 原数组
     * @param newSize 新数组的大小
     * @param <T> 数组元素类型
     * @return 调整后的新数组
     */
    public static <T> T[] resize(T[] buffer,int newSize){
        return resize(buffer,newSize,buffer.getClass().getComponentType());
    }

    /**
     * 将多个数组合并成一个新数组
     * @param arrays 数组集合
     * @param <T> 数组元素类型
     * @return 合并后的新数组
     */
    public static <T> T[] addAll(T[]...arrays){
        if(arrays.length ==1) return arrays[0];
        int length = 0;
        for (T[] array : arrays) {
            if(null!=array) length+=array.length;
        }
        T[] result = newArray(arrays.getClass().getComponentType(),length);
        length = 0;
        for (T[] array : arrays) {
            if(null!=array){
                System.arraycopy(array,0,result,length,array.length);
                length +=array.length;
            }
        }
        return result;
    }

    /**
     * 刨床{@link System#arraycopy(Object, int, Object, int, int)}
     * 数组复制
     * @param src 源数组
     * @param srcPos 原数组开始位置
     * @param target 目标数组
     * @param destPos 目标数组开始位置
     * @param length 拷贝数组长度
     * @return
     */
    public static Object copy(Object src,int srcPos,Object target,int destPos,int length){
        System.arraycopy(src,srcPos,target,destPos,length);
        return target;
    }

    /**
     * 刨床{@link System#arraycopy(Object, int, Object, int, int)}
     * 数组复制
     * @param src 源数组
     * @param target 目标数组
     * @param length 拷贝数组长度
     * @return
     */
    public static Object copy(Object src,Object target,int length){
        System.arraycopy(src,0,target,0,length);
        return target;
    }

    /**
     * 克隆数组
     * @param array 被克隆的数组
     * @param <T> 数组元素类型
     * @return 克隆后的数组对象
     */
    public static <T> T[] clone(T[] array){
        if(array == null) return null;
        return array.clone();
    }


    /**
     * 克隆数组
     * @param obj 被克隆的数组
     * @param <T> 数组元素类型
     * @return 克隆后的数组对象
     */
    public static <T> T clone(final T obj){
        if(isEmpty(obj)) return null;

        if(isArray(obj)){
            final Object result;
            final Class<?> componentType = obj.getClass().getComponentType();
            if(componentType.isPrimitive()){
                int length = Array.getLength(obj);
                result = Array.newInstance(componentType,length);
                while (length-->0){
                    Array.set(result,length,Array.get(obj,length));
                }
            }else{
                result = ((Object[])obj).clone();
            }
            return (T) result;
        }
        return null;
    }

    /**
     * 过滤传入的数组中存在null值的元素
     *
     * @param array 数组
     * @param editor 编辑器接口
     * @param <T> 数组元素类型
     * @return 过滤后的数组
     */
    public static <T> T[] filter(T[] array, Editor<T> editor){
        ArrayList<T> list = new ArrayList<>(array.length);
        T modified;
        for (T t : array) {
            modified = editor.edit(t);
            if(null!=modified) list.add(modified);
        }
        return list.toArray(Arrays.copyOf(array,list.size()));
    }

    /**
     * 编辑数组
     * 编辑过程通过传入的Editor实现来返回需要的元素内容，这个Editor实现可以实现以下功能
     * <pre>
     *     1.修改元素对象，返回集合中为修改后的对象
     * </pre>
     * 注意，此方法会修改原数组
     *
     * @param array 原数组
     * @param editor 编辑器接口
     * @param <T> 数组元素类型
     */
    public static <T> void edit(T[] array,Editor<T> editor){
        for(int i=0;i<array.length;i++){
            array[i] = editor.edit(array[i]);
        }
    }

    /**
     * 过滤器
     * 过滤过程通过传入的FILTER来实现需要返回元素的内容
     * @param array 数组
     * @param filter 过滤器
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> T[] filter(T[]array, Filter<T> filter){
        if(null==filter) return array;
        final ArrayList<T> list = new ArrayList<>(array.length);
        for (T t : array) {
            if(filter.accept(t)) list.add(t);
        }
        final T[] result = newArray(array.getClass().getComponentType(),list.size());
        return list.toArray(result);
    }

    /**
     * 去除 {@code null} 元素
     * @param array 数组
     * @param <T> 数组元素类型
     * @return 去除 {@code null} 元素
     */
    public static <T> T[] removeNull(T[] array){
        return filter(array,(Editor<T>)t->{return t;} );
    }

    /**
     * 去除 {@code null} 元素
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends CharSequence> T[] removeEmpty(T[] array){return filter(array,StringUtil::isNotEmpty);}
    /**
     * 去除 {@code null} 或者 "" 元素
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends CharSequence> T[] removeBlank(T[] array){return filter(array,StringUtil::isNotBlank);}

    /**
     * 数组元素中的null转换为""
     *
     * @param array 原始数组
     * @return 数组元素中的null转换为""
     */
    public static String [] nullToEmpty(String[] array){
        return filter(array,(Editor<String>) t -> null == t ? StringUtil.EMPTY:t);
    }

    /**
     * 映射键值
     *
     * @param keys 键列表
     * @param values 值列表
     * @param isOrder 是否有序
     * @param <K> Key类型
     * @param <V> Value 类型
     * @return 映射键值
     */
    public static <K,V> Map<K,V> zip(K[] keys, V[] values, boolean isOrder){
        if(isEmpty(keys)|| isEmpty(values)) return null;

        final int size = Math.min(keys.length,values.length);
        final Map<K,V> map = CollUtil.newHashMap(size,isOrder);
        for(int i=0;i<size;i++){
            map.put(keys[i],values[i]);
        }
        return map;
    }

    /**
     * 映射键值
     *
     * @param keys 键列表
     * @param values 值列表
     * @param <K> Key类型
     * @param <V> Value 类型
     * @return 映射键值
     */
    public static <K,V> Map<K,V> zip(K[] keys, V[] values){
        return zip(keys,values,false);
    }

    public static <T> int indexOf(T[]array,Object value){
        if(null!=array){
            for (int i=0;i< array.length;i++){
                if(ObjectUtil.equal(value,array[i])){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOfIgnoreCase(CharSequence[] array,CharSequence value){
        if(null !=array){
            for(int i=0;i< array.length;i++){
                if(StringUtil.equalsIgnoreCase(array[i],value)) return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后位置，未找到返回{@link #INDEX_NOT_FOUND}
     * @param array 数组
     * @param value 被检查元素
     * @param <T> 数组类型
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static <T> int lastIndexOf(T[] array,Object value){
        if(null != array){
            for(int i = array.length-1;i>=0;i--){
                if(ObjectUtil.equal(value,array[i])) return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 数组中是否包含元素
     *
     * @param array 数组
     * @param value 被检查的元素
     * @param <T> 数组元素类型
     * @return TRUE||FALSE
     */
    public static <T> boolean contains(T[] array,T value){return indexOf(array,value)>INDEX_NOT_FOUND;}


    /**
     * 数组中知否包含指定元素中的任意一个
     *
     * @param array 数组
     * @param values 北见车的多个元素
     * @param <T> 数组元素类型
     * @return 是否包含指定元素中的任意一个
     */
    public static <T> boolean containsAny(T[] array,T...values){
        for (T value : values) {
            if(contains(array,value)) return true;
        }
        return false;
    }

    /**
     * 数组中是否包含指定元素中的全部
     *
     * @param array  数组
     * @param values 被检查的多个元素
     * @param <T> 数组元素类型
     * @return 是否包含指定元素中的全部
     */
    public static <T> boolean containsAll(T[] array,T...values){
        for (T value : values) {
            if(false == contains(array,value)) return false;
        }
        return true;
    }

    /**
     * 数组中是否包含元素，忽略大小写
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static boolean containsIgnoreCase(CharSequence[] array,CharSequence value){return indexOfIgnoreCase(array,value)>INDEX_NOT_FOUND;}

    public static Object[] wrap(Object obj){
        if(null ==obj) return null;

        if(isArray(obj)){
            try {
                return (Object[]) obj;
            }catch (Exception e){
                final String className = obj.getClass().getComponentType().getName();
                switch (className){
                    case "long":
                        return wrap((long[])obj );
                    case "int":
                        return wrap((int[])obj);
                    case"short":
                        return wrap((short[])obj);
                    case "char":
                        return wrap((char[])obj);
                    case "byte":
                        return wrap((byte[]) obj );
                    case "boolean":
                        return wrap((boolean[]) obj);
                    case"double":
                        return wrap((double[])obj);
                    case "float":
                        return wrap((float[]) obj);
                }
            }
        }
        throw new UtilException(StringUtil.format("[{}] is not Array !",obj.getClass()));
    }


    /**
     * 对象是否为数组对象
     * @param obj
     * @return 返回true或者false
     */

    public static boolean isArray(Object obj){
        return null !=obj&& obj.getClass().isArray();
    }

    /**
     * 获取数组对象中指定index的值，支持负数，例如-1 表示倒数第一个值
     * 如果数组下标越界，返回null
     * @param array 数组
     * @param index 下标值
     * @param <T> 数组元素类型
     * @return 取数组对象中指定index的值，支持负数，例如-1 表示倒数第一个值
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Object array,int index){
        if(null == array) return null;

        if(index <0) index+=Array.getLength(array);

        try {
            return (T) Array.get(array,index);
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * 获取数组中指定多个下标元素值，组成新数组
     * @param array 原数组
     * @param indexes 下标索引参数列表
     * @param <T> 数组元素类型
     * @return 获取数组中指定多个下标元素值，组成新数组
     */
    public static <T> T[] getAny(Object array,int...indexes){
        if(null == array) return null;
        final T[] result = newArray(array.getClass().getComponentType(),indexes.length);
        for (int index : indexes) {
            result[index] = get(array,index);
        }
        return result;
    }

    /**
     * 获取子数组
     *
     * @param array 数组
     * @param start 开始位置(包括)
     * @param end 结束位置(不包括)
     * @param <T> 数组元素类型
     * @return 返回子数组
     */
    public static <T> T[] sub(T[]array,int start,int end){
        int length = length(array);
        if(start<0)  start+=length;
        if(end<0) end+=length;
        if(start ==length) return newArray(array.getClass().getComponentType(),0);
        if(start>end){
            start = start^end;
            end = start^end;
            start = start^end;
        }
        if(end>length){
            if(start>=length) return newArray(array.getClass().getComponentType(),0);
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    public static Object[] sub(Object array,int start,int end){return sub(array,start,end,1);}

    public static Object[] sub(Object array,int start,int end,int step){
        int length = length(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start == length) return new Object[0];
        if(start > end){
            start = start^end;
            end = start^end;
            start = start^end;
        }
        if(end>length){
            if(start>=length) return new Object[0];
            end = length;
        }
        if(start <=1) step = 1;
        final ArrayList<Object> list = new ArrayList<>();
        for(int i=start;i<end;i+=step){
            list.add(get(array,i));
        }
        return list.toArray();
    }

    public static String toString(Object obj){
        if(null == obj) return null;
        if(obj instanceof long[]) return Arrays.toString((long[]) obj);
        if(obj instanceof int[]) return Arrays.toString((int[]) obj);
        if(obj instanceof short[]) return Arrays.toString((short[]) obj);
        if(obj instanceof char[]) return Arrays.toString((char[]) obj);
        if(obj instanceof byte[]) return Arrays.toString((byte[]) obj);
        if(obj instanceof double[]) return Arrays.toString((double[]) obj);
        if(obj instanceof float[]) return Arrays.toString((float[]) obj);
        if(obj instanceof boolean[]) return Arrays.toString((boolean[]) obj);
        if(ArrayUtil.isArray(obj)){
            try {
                return Arrays.deepToString((Object[]) obj);
            }catch (Exception ignore){

            }
        }
        return obj.toString();
    }
    public static int length(Object array) throws IllegalArgumentException{
        if(null == array) return 0;
        return Array.getLength(array);
    }

    public static <T>String join(T[] array,CharSequence conjunction){return join(array,conjunction,null,null);}

    public static <T>String join(T[] array,CharSequence conjunction,String prefix,String suffix){
        if(null == array)return null;

        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (T item : array) {
            if(isFirst){
                isFirst = false;
            }else {
                sb.append(conjunction);
            }
            if(ArrayUtil.isArray(item)){
                sb.append(join(ArrayUtil.wrap(item),conjunction,prefix,suffix));
            }else if(item instanceof Iterator<?>){
                sb.append(CollUtil.join((Iterable<?>) item, conjunction, prefix, suffix));
            }else if(item instanceof Iterator<?>){
                sb.append(IterUtil.join((Iterator<?>)item,conjunction,prefix,suffix));
            }else {
                sb.append(StringUtil.wrap(StringUtil.toString(item),prefix,suffix));
            }
        }
        return sb.toString();
    }

    public static <T> String join(T[] array,CharSequence conjunction,Editor<T> editor){
        if(null==array) return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (T t : array) {
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            if(null!=editor){
                t = editor.edit(t);
            }
            if(null!=t){
                sb.append(StringUtil.toString(t));
            }
        }
        return sb.toString();
    }

    public static String join(long[] array,CharSequence conjunction){
        if(null == array) return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (long item : array) {
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    public static String join(Object array,CharSequence conjunction){
        if(null == array) throw new NullPointerException("Array must be not null!");

        if(!isArray(array)) throw new IllegalArgumentException(StringUtil.format("[{}] is not a Array",array.getClass()));
        final Class<?> componentType = array.getClass().getComponentType();
        if(componentType.isPrimitive()){
            final String componentTypeName = componentType.getName();
            switch (componentTypeName){
                case "long":
                    return join((long[]) array,conjunction);
                case "int":
                    return join((int[]) array,conjunction);
                case "char":
                    return join((char[]) array,conjunction);
                case "short":
                    return join((short[]) array,conjunction);
                case "byte":
                    return join((byte[]) array,conjunction);
                case "double":
                    return join((double[]) array,conjunction);
                case "float":
                    return join((float[]) array,conjunction);
                case "boolean":
                    return join((boolean[]) array,conjunction);
                default:
                    throw new UtilException("Unknown primitive type : [{}] ",componentTypeName);
            }
        }else {
            return join((Object[]) array,conjunction);
        }
    }

    /**
     * {@link ByteBuffer} 转byte 数组
     * @param buffer
     * @return 将集合转为数组
     */
    public static byte[] toArray(ByteBuffer buffer){
        if(buffer.hasArray()){
            return Arrays.copyOfRange(buffer.array(),buffer.position(),buffer.limit());
        }else {
            int oldPosition = buffer.position();
            buffer.position(0);
            int size = buffer.limit();
            byte[] buffers = new byte[size];
            buffer.get(buffers);
            buffer.position(oldPosition);
            return buffers;
        }
    }

    /**
     * 将集合转为数组
     *
     * @param iterator {@link Iterator}
     * @param componentType 集合元素类型
     * @param <T> 数组元素类型
     * @return 将集合转为数组
     */
    public static <T> T[] toArray(Iterator<T> iterator, Class<T> componentType) {
        return toArray(CollUtil.newArrayList(iterator), componentType);
    }

    /**
     * 将集合转为数组
     *
     * @param iterable {@link Iterator}
     * @param componentType 集合元素类型
     * @param <T> 数组元素类型
     * @return 将集合转为数组
     */
    public static <T> T[] toArray(Iterable<T> iterable, Class<T> componentType) {
        return toArray(CollectionUtil.toCollection(iterable), componentType);
    }

    /**
     * 将集合转为数组
     *
     * @param collection 集合
     * @param componentType 集合元素类型
     * @param <T> 数组元素类型
     * @return 将集合转为数组
     */
    public static <T> T[] toArray(Collection<T> collection,Class<T> componentType){
        return collection.toArray(newArray(componentType,0));
    }

    /**
     * 移除数组中对应位置的元素
     * @param array 目标数组
     * @param index 数组删除的下标值
     * @param <T> 数组元素类型
     * @return 删除成功，返回修改后的数组，删除失败，返回原数组
     * @throws IllegalArgumentException
     */
    public static <T> T[] remove(T[] array,int index) throws IllegalArgumentException{
        return (T[])remove((Object)array,index);
    }

    /**
     * 移除数组中对应位置的元素
     * @param array 目标数组
     * @param element 需要删除的元素
     * @param <T> 数组元素类型
     * @return 返回删除后的数组
     * @throws IllegalArgumentException
     */
    public static <T> T[] remove(T[] array,T element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }

    /**
     * 数组反转，改变原数组顺序
     *
     * @param array 原数组
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置（不包含）
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> T[] reverse(T[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array) ) return array;
        int i =Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive)-1;
        T tmp;
        while (j>i){
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转，改变原数组顺序
     *
     * @param array 原数组
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> T[] reverse(T[] array){
       return reverse(array,0,array.length);
    }

    /**
     * 数组元素中取最小值
     *
     * @param numberArray 数字数组
     * @param <T> 元素类型
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T[] numberArray){return min(numberArray,null);}

    /**
     * 数组元素中取最小值
     *
     * @param numberArray 数字数组
     * @param <T> 元素类型
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T[] numberArray,Comparator<T> comparator){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty");

        T min = numberArray[0];
        for (T t : numberArray) {
            if(CompareUtil.compare(min,t,comparator)>0){
                min = t;
            }
        }
        return min;
    }

    /**
     * 数组元素中取最大值
     *
     * @param numberArray 数字数组
     * @param <T> 元素类型
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T[] numberArray){return max(numberArray,null);}

    /**
     * 数组元素中取最大值
     *
     * @param numberArray 数字数组
     * @param <T> 元素类型
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T[] numberArray,Comparator<T> comparator){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty");

        T max = numberArray[0];
        for (T t : numberArray) {
            if(CompareUtil.compare(max,t,comparator)<0){
                max = t;
            }
        }
        return max;
    }

    /**
     * 打乱数组顺序
     *
     * @param array 原数组
     * @param <T> 数组元素类型
     * @return 打乱后的数组
     */
    public static <T> T[] shuffle(T[] array){return shuffle(array,RandomUtil.getRandom());}

    /**
     * 打乱数组顺序
     *
     * @param array 原数组
     * @param random 随机数生成器
     * @param <T> 数组元素类型
     * @return 打乱后的数组
     */
    public static <T> T[] shuffle(T[] array,Random random){
        if(array==null||random==null||array.length <=1) return array;

        for(int i= array.length;i>1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    /**
     * 交换两个位置的值
     * @param array
     * @param index1
     * @param index2
     * @param <T>
     * @return
     */
    public static <T> T[] swap(T[] array,int index1,int index2){
        if(isEmpty(array)) throw new IllegalArgumentException("Array must not empty");
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    /**
     * 交换两个位置的值
     * @param array
     * @param index1
     * @param index2
     * @param <T>
     * @return
     */
    public static <T> Object swap(Object array,int index1,int index2){
        if(isEmpty(array)) throw new IllegalArgumentException("Array must not empty");
        Object tmp = get(array,index1);
        Array.set(array,index1,Array.get(array,index2));
        Array.set(array,index2,tmp);
        return array;
    }

    /**
     * 计算{@code null} 或者空元素对象的个数,通过{@ObjectUtil#isEmpey(Object)} 判断元素
     *
     * @param args 被检查的对象，一个或者多个
     * @return 存在{@code null} 的数量
     */
    public static int emptyCount(Object...args){
        int count = 0;
        if(isNotEmpty(args)){
            for (Object element : args) {
                if(ObjectUtil.isEmpty(element)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 是否存在{@code null} 或者空对象，通过{@link ObjectUtil#isEmpty(Object)} 判断元素
     * @param args
     * @return
     */
    public static boolean hasEmpty(Object...args){
        if(isNotEmpty(args)){
            for (Object arg : args) {
                if(ObjectUtil.isEmpty(arg)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否存在都为{@code null} 或者空对象，通过{@link ObjectUtil#isEmpty(Object)} 判断元素
     * @param args
     * @return
     */
    public static boolean isAllEmpty(Object...args){return emptyCount(args)==args.length;}
    /**
     * 是否存在都不为{@code null} 或者空对象，通过{@link ObjectUtil#isEmpty(Object)} 判断元素
     * @param args
     * @return
     */
    public static boolean isAllNotEmpty(Object...args){ return false == hasEmpty(args);}

    /**
     * 多个字段全部不为null
     * @param array
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean isAllNotNull(T...array){ return false==hasNull(array);}

    /**
     * 去重数组中的元素，去重后生成新的数组，原数组不变
     *
     * @param array 数组
     * @param <T> 数组元素类型
     * @return 去重后的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] distinct(T[] array){
        if(isEmpty(array)) return array;

        final Set<T> set = new LinkedHashSet<>(array.length,1);
        Collections.addAll(set,array);
        return toArray(set,(Class<T>) getComponentType(array));
    }

    /**
     * 按照指定规则，将一种类型的数组转换为另一种类型
     * @param array 被转换的数组
     * @param targetComponentType 目标元素类型
     * @param func 转换规则函数
     * @param <T> 原始数组类型
     * @param <R> 目标数组类型
     * @return 转换后的数组
     */
    public static <T,R> R[] map(Object array, Class<R> targetComponentType, Function<? super T,? extends R> func){
        final int length = length(array);
        final R[] result = newArray(targetComponentType,length);
        for(int i=0;i<length;i++){
            result[i] = func.apply(get(array,i));
        }
        return result;
    }

    /**
     * 按照指定规则，将一种类型的数组元素提取后转换为List
     * @param array 被转换的数组
     * @param func 转换规则函数
     * @param <T> 原始数组类型
     * @param <R> 目标数组类型
     * @return 转换后的数组
     */
    public static <T,R> List<R> map(T[] array, Function<? super T,? extends R> func){
       return Arrays.stream(array).map(func).collect(Collectors.toList());
    }

    /**
     * 判断两个数组是否相等，判断依据包括数组商都和每个元素都相等
     *
     * @param array1 数组1
     * @param array2 数组2
     * @return
     */
    public static boolean equals(Object array1,Object array2){
        if(array1==array2) return true;
        if(hasNull(array1,array2)) return false;
        Assert.isTrue(isArray(array1),"First is not a Array !");
        Assert.isTrue(isArray(array2),"Second is not a Array !");
        if(array1 instanceof long[]){
            return Arrays.equals((long[]) array1,(long[]) array2);
        }else if(array1 instanceof short[]){
            return Arrays.equals((short[]) array1,(short[]) array2);
        }else if(array1 instanceof char[]){
            return Arrays.equals((char[]) array1,(char[]) array2);
        }else if(array1 instanceof int[]){
            return Arrays.equals((int[]) array1,(int[]) array2);
        }else if(array1 instanceof byte[]){
            return Arrays.equals((byte[]) array1,(byte[]) array2);
        }else if(array1 instanceof boolean[]){
            return Arrays.equals((boolean[]) array1,(boolean[]) array2);
        }else if(array1 instanceof double[]){
            return Arrays.equals((double[]) array1,(double[]) array2);
        }else if(array1 instanceof float[]){
            return Arrays.equals((float[]) array1,(float[]) array2);
        }else{
            return Arrays.deepEquals((Object[]) array1,(Object[]) array2);
        }
    }

    /**
     * 查找子数组的位置
     * @param array 数组
     * @param subArray 子数组
     * @param <T> 数组元素类型
     * @return 子数组的开始位置，即子数组第一个元素在数组中的位置
     */
    public static <T> boolean isSub(T[]array,T[] subArray){return indexOf(array,subArray)>INDEX_NOT_FOUND;}

    /**
     * 查找子数组的位置
     * @param array 数组
     * @param subArray 子数组
     * @param <T> 数组元素类型
     * @return 子数组的开始位置，即子数组第一个元素在数组中的位置
     */
    public static <T> int indexOfSub(T[] array,T[] subArray){
        if(isEmpty(array)||isEmpty(subArray)|| subArray.length>array.length) return INDEX_NOT_FOUND;
        int firstIndex = indexOf(array,subArray[0]);
        if(firstIndex<0||firstIndex+ subArray.length>array.length){
            return INDEX_NOT_FOUND;
        }
        for(int i=0;i<subArray.length;i++){
            if(!ObjectUtil.equal(array[i+firstIndex],subArray[i])){
                return INDEX_NOT_FOUND;
            }
        }
        return firstIndex;
    }

    /**
     * 查找最后一个子数组的开始位置
     * @param array 数组
     * @param subArray 子数组
     * @param <T> 数组元素类型
     * @return 最后一个子数组的开始位置，即子数组第一个元素在数组中的位置
     */
    public static <T> int lastIndexOfSub(T[] array,T[] subArray){
        if(isEmpty(array)||isEmpty(subArray)|| subArray.length>array.length) return INDEX_NOT_FOUND;

        int firstIndex = lastIndexOf(array,subArray[0]);

        if(firstIndex<0||firstIndex+ subArray.length>array.length){
            return INDEX_NOT_FOUND;
        }
        for(int i=0;i<subArray.length;i++){
            if(!ObjectUtil.equal(array[i+firstIndex],subArray[i])){
                return INDEX_NOT_FOUND;
            }
        }
        return firstIndex;
    }

    /**
     * 检查数组是否有序，即comparator.compare(array[i],array[i+1]) &lt;=0,若传入空数组或空比较器，则返回false
     *
     * @param array 数组
     * @param comparator 比较器
     * @param <T> 数组元素类型
     * @return
     */
    public static <T> boolean isSorted(T[] array,Comparator<? super T> comparator){
        if(array==null||comparator==null) return false;
        for(int i=0;i<array.length;i++){
            if(comparator.compare(array[i],array[i+1])>0) return false;
        }
        return true;
    }

    /**
     * 检查数组是否升序,即comparator.compare(array[i],array[i+1]) &lt;=0,若传入空数组或空比较器，则返回false
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean isSorted(T[] array){return isSortedASC(array);}

    /**
     * 检查数组是否升序,即comparator.compare(array[i],array[i+1]) &lt;=0,若传入空数组或空比较器，则返回false
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean isSortedASC(T[] array){
        if(array == null) return false;

        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(array[i+1])>0) return false;
        }
        return true;
    }

    /**
     * 检查数组是否降序,即comparator.compare(array[i],array[i+1]) &lt;=0,若传入空数组或空比较器，则返回false
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean isSortedDESC(T[] array){
        if(array == null) return false;

        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(array[i+1])<0) return false;
        }
        return true;
    }
}
