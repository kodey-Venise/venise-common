package me.venise.core.clone;

import me.venise.core.exceptions.ExceptionUtil;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/22 16:03
 */
public class CloneRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 6274217608538274974L;

    public CloneRuntimeException(Throwable e){super(ExceptionUtil.getMessage(e));}

    public CloneRuntimeException(String message){super(message);}

    public CloneRuntimeException(String messageTemplate,Object ...params){
        super(String.format(messageTemplate,params));
    }

    public CloneRuntimeException(Throwable throwable,String messageTemplate,Object ...params){
        super(String.format(messageTemplate,params),throwable);
    }
}


