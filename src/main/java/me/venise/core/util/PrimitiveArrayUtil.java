package me.venise.core.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 原始数组工具类
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/22 17:39
 */
public class PrimitiveArrayUtil {

    /**
     * 数组中元素未找到的小标，值为 -1
     */
    public static final int INDEX_NOT_FOUND = -1;

    public static boolean isEmpty(long [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(int [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(short [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(char [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(byte [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(double [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(float [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(boolean [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Long [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Integer [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Character [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(String [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Double [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Float [] array){return array ==null || array.length == 0;}
    public static boolean isEmpty(Boolean [] array){return array ==null || array.length == 0;}

    public static boolean isNotEmpty(long[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(int[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(short[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(char[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(byte[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(double[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(float[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(boolean[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Long[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Integer[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Double[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Character[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Float[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(String[] array){return false == isEmpty(array);}
    public static boolean isNotEmpty(Boolean[] array){return false == isEmpty(array);}


    /**
     * 生成一个新的重新设置大小的数组
     * 调整大小后拷贝原始数据组到新数组下，扩大则站位前N个位置，其它位置补充0，则缩小截断
     * @param bytes
     * @param newSize
     * @return
     */
    public static byte[] resize(byte[] bytes,int newSize){
        if(newSize<0){
            return bytes;
        }
        final byte[] newArray = new byte[newSize];
        if(isNotEmpty(bytes)){
            System.arraycopy(bytes,0,newArray,0,Math.min(bytes.length,newSize));
        }
        return newArray;
    }

    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static byte[] addAll(byte [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(byte[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final byte[] result = new byte[length];
        length = 0;
        for (byte[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }


    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static int[] addAll(int [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(int[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final int[] result = new int[length];
        length = 0;
        for (int[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }



    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static long[] addAll(long [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(long[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final long[] result = new long[length];
        length = 0;
        for (long[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }




    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static char[] addAll(char [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(char[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final char[] result = new char[length];
        length = 0;
        for (char[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }




    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static double[] addAll(double [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(double[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final double[] result = new double[length];
        length = 0;
        for (double[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }




    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static float[] addAll(float [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(float[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final float[] result = new float[length];
        length = 0;
        for (float[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }




    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static Character[] addAll(Character [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(Character[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final Character[] result = new Character[length];
        length = 0;
        for (Character[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }




    /**
     * 将多个数组合并在一起 忽略NULL 的数组
     * @param arrays 数组集合
     * @return 合并后的数组
     */
    public static String[] addAll(String [] ...arrays){
        if(arrays.length ==1){
            return arrays[0];
        }
        //计算长度
        int length = 0;
        for(String[] array:arrays){
            if(null !=array){
                length+=array.length;
            }
        }

        final String[] result = new String[length];
        length = 0;
        for (String[] array:arrays){
            if(null != array){
                System.arraycopy(array,0,result,length,array.length);
                length += array.length;
            }
        }
        return result;
    }


    /**
     * 生成一个数字列表，自动判断正序反序
     *
     * @param excludedEnd 结束数字(不包含)
     * @return
     */
    public static int[] range(int excludedEnd){return range(0,excludedEnd,1);}

    /**
     * 生成一个数字列表，自动判断正序反序
     *
     * @param includedStart 开始数字(包含)
     * @param excludedEnd 结束数字(不包含)
     * @return
     */
    public static int[] range(int includedStart,int excludedEnd){return range(includedStart,excludedEnd,1);}

    /**
     * 生成一个数字列表，自动判断正序反序
     * @param includedStart 开始数字(包含)
     * @param excludedEnd 结束数字(不包含)
     * @param step
     * @return
     */
    public static int[] range(int includedStart,int excludedEnd,int step){
        if(includedStart > excludedEnd){
            int tmp = includedStart;
            includedStart = excludedEnd;
            excludedEnd = tmp;
        }

        if(step <=0){
            step = 1;
        }

        int deviation = excludedEnd - includedStart;
        int length = deviation/step;
        if(deviation %step !=0){
            length +=1;
        }
        int [] range = new int[length];
        for(int i=0;i<length;i++){
            range[i] = includedStart;
            includedStart += step;
        }
        return range;
    }

    /**
     * 拆分byte 数组为等份(最后一份按照剩余长度分配空间)
     * @param array
     * @param len
     * @return
     */
    public static byte[][] split(byte[] array,int len){
        int amount = array.length / len;
        final int remainder = array.length % len;
        if( remainder != 0){
            ++ amount;
        }
        final byte[][] arrays = new byte[amount][];
        byte[] arr;
        for(int i=0;i<amount;i++){
            if(i== amount -1 && remainder !=0){
                //有剩余，按照实际长度创建
                arr = new byte[remainder];
                System.arraycopy(array,i*len,arr,0,remainder);
            }else{
                arr = new byte[len];
                System.arraycopy(array,i*len,arr,0,len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(long [] array,long value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }


    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(int [] array,int value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(char [] array,char value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(byte [] array,byte value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(double [] array,double value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(float [] array,float value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     */
    public static int indexOf(boolean [] array,boolean value){
        if(null != array){
            for(int i=0;i< array.length;i++){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(long [] array,long value){
        if(null != array){
            for(int i=array.length -1;i>=0;i--){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(int [] array,int value){
        if(null != array){
            for(int i=array.length -1;i>=0;i--){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(char [] array,char value){
        if(null != array){
            for(int i=array.length -1;i>=0;i--){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(double [] array,double value){
        if(null != array){
            for(int i=array.length -1;i>=0;i--){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     *
     * @param array 数组
     * @param value 被检查的元素
     * @return 返回数组中指定元素所在最后的位置，未找到{@link #INDEX_NOT_FOUND}
     */
    public static int lastIndexOf(float [] array,float value){
        if(null != array){
            for(int i=array.length -1;i>=0;i--){
                if(value == array[i]){
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }


    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(long[] array,long value){return indexOf(array,value) > INDEX_NOT_FOUND;}
    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(int[] array,int value){return indexOf(array,value) > INDEX_NOT_FOUND;}

    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(char[] array,char value){return indexOf(array,value) > INDEX_NOT_FOUND;}

    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(double[] array,double value){return indexOf(array,value) > INDEX_NOT_FOUND;}

    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(float[] array,float value){return indexOf(array,value) > INDEX_NOT_FOUND;}

    /**
     * 数组是否包含元素
     * @param array 数组
     * @param value 被检查的元素
     * @return
     */
    public static boolean contains(boolean[] array,boolean value){return indexOf(array,value) > INDEX_NOT_FOUND;}


    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Integer[] wrap(int... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Integer[0];
        }
        final Integer[] array = new Integer[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Long[] wrap(long... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Long[0];
        }
        final Long[] array = new Long[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Double[] wrap(double... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Double[0];
        }
        final Double[] array = new Double[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Float[] wrap(float... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Float[0];
        }
        final Float[] array = new Float[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Character[] wrap(char... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Character[0];
        }
        final Character[] array = new Character[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Byte[] wrap(byte... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Byte[0];
        }
        final Byte[] array = new Byte[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Short[] wrap(short... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Short[0];
        }
        final Short[] array = new Short[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将原始类型数组包装为包装类型
     * @param values
     * @return
     */
    public static Boolean[] wrap(boolean... values){
        if(null== values) return null;
        final int length = values.length;
        if(0==length){
            return new Boolean[0];
        }
        final Boolean[] array = new Boolean[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }



    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static int[] unWrap(Integer... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new int[0];
        final int[] array = new int[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static long[] unWrap(Long... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new long[0];
        final long[] array = new long[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static double[] unWrap(Double... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new double[0];
        final double[] array = new double[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static float[] unWrap(Float... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new float[0];
        final float[] array = new float[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static char[] unWrap(Character... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new char[0];
        final char[] array = new char[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static byte[] unWrap(Byte... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new byte[0];
        final byte[] array = new byte[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static short[] unWrap(Short... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new short[0];
        final short[] array = new short[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型转换为原始类型数组,null转换为0
     * @param values
     * @return
     */
    public static boolean[] unWrap(Boolean... values){
        if(null == values) return null;
        final int length = values.length;
        if(0==length) return new boolean[0];
        final boolean[] array = new boolean[length];
        for(int i=0;i<length;i++){
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static byte[] sub(byte[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new byte[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new byte[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static int[] sub(int[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new int[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new int[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static long[] sub(long[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new long[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new long[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static double[] sub(double[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new double[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new double[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static float[] sub(float[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new float[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new float[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static char[] sub(char[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new char[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new char[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static short[] sub(short[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new short[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new short[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }

    /**
     * 获取子数组
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */

    public static boolean[] sub(boolean[] array,int start,int end){
        int length = Array.getLength(array);
        if(start<0) start+=length;
        if(end<0) end+=length;
        if(start==length) return new boolean[0];
        if(start>end){
            int temp = start;
            start = end;
            end= temp;
        }
        if(end>length){
            if(start>=length){
                return new boolean[0];
            }
            end = length;
        }
        return Arrays.copyOfRange(array,start,end);
    }


    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(int[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (int item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(long[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (long item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(double[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (double item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(float[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (float item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(char[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (char item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(short[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (short item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(boolean[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (boolean item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 以 conjunction 为分隔符将数组转换为字符串
     * @param array
     * @param conjunction
     * @return
     */
    public static String join(byte[] array,CharSequence conjunction){
        if(null==array)return null;
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (byte item:array){
            if(isFirst){
                isFirst = false;
            }else{
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }

    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static long[] remove(long[] array,int index)throws IllegalArgumentException{
        return (long[]) remove((Object)array,index);
    }
    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static int[] remove(int[] array,int index)throws IllegalArgumentException{
        return (int[]) remove((Object)array,index);
    }
    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static short[] remove(short[] array,int index)throws IllegalArgumentException{
        return (short[]) remove((Object)array,index);
    }
    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static double[] remove(double[] array,int index)throws IllegalArgumentException{
        return (double[]) remove((Object)array,index);
    }

    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static float[] remove(float[] array,int index)throws IllegalArgumentException{
        return (float[]) remove((Object)array,index);
    }

    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static char[] remove(char[] array,int index)throws IllegalArgumentException{
        return (char[]) remove((Object)array,index);
    }

    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean[] remove(boolean[] array,int index)throws IllegalArgumentException{
        return (boolean[]) remove((Object)array,index);
    }

    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static byte[] remove(byte[] array,int index)throws IllegalArgumentException{
        return (byte[]) remove((Object)array,index);
    }


    /**
     * 移除数组中对应位置的元素
     * @param array
     * @param index
     * @return
     * @throws IllegalArgumentException
     */
    public static Object remove(Object array,int index)throws IllegalArgumentException{
        if(null==array) return null;

        int length = Array.getLength(array);
        if(index<0||index>=length) return array;

        final Object result = Array.newInstance(array.getClass().getComponentType(),length-1);
        System.arraycopy(array,0,result,0,index);
        if(index<length-1){
            System.arraycopy(array,index+1,result,index,length - index -1);
        }
        return result;
    }


    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static long [] removeEle(long[] array,long element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }

    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static int [] removeEle(int[] array,int element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }
    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static byte [] removeEle(byte[] array,byte element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }
    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static char [] removeEle(char[] array,char element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }
    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static double [] removeEle(double[] array,double element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }
    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static float [] removeEle(float[] array,float element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }
    /**
     * 移除数组中指定元素
     * 只会移除匹配到的第一个元素
     * @param array 数组对象，可以是对象数据，也可以是原始类型数组
     * @param element 要移除的元素
     * @return 去除指定元素后的新数组或者原数组
     * @throws IllegalArgumentException
     */
    public static boolean [] removeEle(boolean[] array,boolean element) throws IllegalArgumentException{
        return remove(array,indexOf(array,element));
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static long[] reverse(long[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        long tmp;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static long[] reverse(long[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static int[] reverse(int[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        int tmp;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static int[] reverse(int[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static byte[] reverse(byte[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        byte tmp;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static byte[] reverse(byte[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static char[] reverse(char[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static char[] reverse(char[] array){return reverse(array,0,array.length);}


    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static double[] reverse(double[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static double[] reverse(double[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }


    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static float[] reverse(float[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static float[] reverse(float[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static boolean[] reverse(boolean[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static boolean[] reverse(boolean[] array){return reverse(array,0,array.length);}

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @param startIndexInclusive 开始位置(包含)
     * @param endIndexExclusive 结束位置(不包含)
     * @return 变更后的数组
     */
    public static short[] reverse(short[] array,final int startIndexInclusive,final int endIndexExclusive){
        if(isEmpty(array)) return array;
        int i = Math.max(startIndexInclusive,0);
        int j = Math.min(array.length,endIndexExclusive) -1;
        while (j>i){
            swap(array,i,j);
            j--;
            i++;
        }
        return array;
    }

    /**
     * 反转数据，会变更原数组
     * @param array 原始数组，会变更
     * @return 变更后的数组
     */
    public static short[] reverse(short[] array){return reverse(array,0,array.length);}

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static long min(long... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        long min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static int min(int... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        int min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static byte min(byte... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        byte min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static short min(short... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        short min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static char min(char... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        char min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static double min(double... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        double min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }

    /**
     * 取最小值
     * @param numberArray
     * @return
     */

    public static float min(float... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        float min = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(min>numberArray[i]){
                min= numberArray[i];
            }
        }
        return min;
    }


    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static long max(long... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        long max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static int max(int... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        int max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static byte max(byte... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        byte max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static char max(char... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        char max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static short max(short... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        short max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static double max(double... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        double max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    /**
     * 取最大值
     * @param numberArray
     * @return
     */

    public static float max(float... numberArray){
        if(isEmpty(numberArray)) throw new IllegalArgumentException("Number array must not empty !");
        float max = numberArray[0];
        for(int i=0;i<numberArray.length;i++){
            if(max < numberArray[i]){
                max= numberArray[i];
            }
        }
        return max;
    }

    public static int[] shuffle(int[] array){
        return shuffle(array,RandomUtil.getRandom());
    }

    public static int[] shuffle(int[] array, Random random){
        if(array==null || random==null||array.length<=1) return array;

        for(int i = array.length;i > 1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    public static long[] shuffle(long[] array){
        return shuffle(array,RandomUtil.getRandom());
    }

    public static long[] shuffle(long[] array, Random random){
        if(array==null || random==null||array.length<=1) return array;

        for(int i = array.length;i > 1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    public static byte[] shuffle(byte[] array){
        return shuffle(array,RandomUtil.getRandom());
    }

    public static byte[] shuffle(byte[] array, Random random){
        if(array==null || random==null||array.length<=1) return array;

        for(int i = array.length;i > 1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    public static short[] shuffle(short[] array){
        return shuffle(array,RandomUtil.getRandom());
    }

    public static short[] shuffle(short[] array, Random random){
        if(array==null || random==null||array.length<=1) return array;

        for(int i = array.length;i > 1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    public static float[] shuffle(float[] array){
        return shuffle(array,RandomUtil.getRandom());
    }

    public static float[] shuffle(float[] array, Random random){
        if(array==null || random==null||array.length<=1) return array;

        for(int i = array.length;i > 1;i--){
            swap(array,i-1,random.nextInt(i));
        }
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static int[] swap(int[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        int tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static long[] swap(long[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        long tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static double[] swap(double[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        double tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static float[] swap(float[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        float tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static char[] swap(char[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        char tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static short[] swap(short[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        short tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static boolean[] swap(boolean[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        boolean tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }

    /**
     * 交换数组中两个位置的值
     * @param array 数组
     * @param startIndex 开始位置
     * @param endIndex 结束位置
     * @return
     */
    public static byte[] swap(byte[] array,int startIndex,int endIndex){
        if(isEmpty(array))throw new IllegalArgumentException("Number array must not empty !");

        byte tmp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = tmp;
        return array;
    }


    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(byte[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(byte[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(byte[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(int[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(int[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(int[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(long[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(long[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(long[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(char[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(char[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }
    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDEASC(char[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(short[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(short[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }
    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(short[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(double[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(double[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }
    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(double[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSorted(float[] array){return isSortedASC(array);};

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedASC(float[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]>array[i]+1){
                return false;
            }
        }
        return true;
    }

    /**
     * 检查数组是否升序
     * @param array
     * @return
     */
    public static boolean isSortedDESC(float[] array){
        if(array==null) return false;

        int length = array.length;
        for(int i=0;i<length -1;i++){
            if(array[i]<array[i]+1){
                return false;
            }
        }
        return true;
    }





}
