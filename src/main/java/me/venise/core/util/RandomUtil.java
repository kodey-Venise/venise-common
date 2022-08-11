package me.venise.core.util;



import me.venise.core.exceptions.UtilException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/27 10:29
 */
public class RandomUtil {

    public static final String BASE_NUMBER = "0123456789";

    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";

    public static final String BASE_CHAR_NUMBER = BASE_CHAR+BASE_NUMBER;

    /**
     * 获取随机生成器对象
     * @return
     */
    public static ThreadLocalRandom getRandom(){return ThreadLocalRandom.current();}

    /**
     * 创建{@link SecureRandom}，类提供加密的强随机数生成器
     * @param sed
     * @return
     */
    public static SecureRandom createSecureRandom(byte[] sed){
        return (null==sed)? new SecureRandom(): new SecureRandom(sed);
    }

    public static SecureRandom getSecureRandom(){ return getSecureRandom(null);}

    public static SecureRandom getSecureRandom(byte[] sed){return createSecureRandom(sed);}

    public static SecureRandom getSHA1PRNGRandom(byte[] seed){
        SecureRandom random;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        }catch (NoSuchAlgorithmException e){
            throw new UtilException(e);
        }
        if(null != seed){
            random.setSeed(seed);
        }
        return random;
    }

    /**
     * 获取随机数产生器
     * @param isSecure
     * @return
     */
    public static Random getRandom(boolean isSecure){return isSecure?getSecureRandom():getRandom();}

    /**
     * 获取随机数boolean值
     * @return
     */
    public static boolean randomBoolean(){return 0== randomInt(2);}

    /**
     * 获取指定范围内的随机数
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min,int max){return getRandom().nextInt(min,max);}

    /**
     * 获取随机数int值
     * @return
     */
    public static int randomInt(){return getRandom().nextInt();}

    /**
     * 获取指定范围内随机数[0,limit]
     * @param limit
     * @return
     */
    public static int randomInt(int limit){return getRandom().nextInt(limit);}

    /**
     * 获取指定范围内的随机数
     * @param min
     * @param max
     * @return
     */
    public static long randomLong(long min,long max){return getRandom().nextLong(min,max);}

    /**
     * 获取随机数int值
     * @return
     */
    public static long randomLong(){return getRandom().nextLong();}

    /**
     * 获取指定范围内随机数[0,limit]
     * @param limit
     * @return
     */
    public static long randomLong(int limit){return getRandom().nextLong(limit);}


}
