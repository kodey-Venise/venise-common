package me.venise.core.exceptions;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/22 16:12
 */
public class ExceptionUtil {

    /**
     * 获得完整消息，包括异常名称，消息格式为: {SimpleClassName}:{ThrowableMessage}
     * @param e
     * @return
     */
    public static String getMessage(Throwable e){
        if(null == e){
            return "NULL";
        }
        return String.format("{}:{}",e.getClass().getSimpleName(),e.getMessage());
    }

    /**
     * 获得消息，调用异常类getMessage方法
     * @param e
     * @return
     */
    public static String getSimpleMessage(Throwable e){return (null ==e)? "NULL":e.getMessage();}


    /**
     * 使用运行时异常包装编译异常
     * @param throwable
     * @return
     */
    public static RuntimeException wrapRuntime(Throwable throwable){
        if(throwable instanceof RuntimeException) return (RuntimeException) throwable;

        return new RuntimeException(throwable);
    }

    /**
     * 将指定消息包装为运行时异常
     * @param message
     * @return
     */
    public static RuntimeException wrapRuntime(String message){return new RuntimeException(message);}


}
