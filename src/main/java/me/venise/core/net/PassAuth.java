package me.venise.core.net;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 16:22
 */
public class PassAuth extends Authenticator {

    /**
     * 创建账号密码形式的{@link Authenticator} 实现。
     *
     * @param user 用户名
     * @param pass 密码
     * @return PassAuth
     */
    public static PassAuth of(String user, char[] pass) {
        return new PassAuth(user, pass);
    }

    private final PasswordAuthentication auth;

    /**
     * 构造
     *
     * @param user 用户名
     * @param pass 密码
     */
    public PassAuth(String user, char[] pass) {
        auth = new PasswordAuthentication(user, pass);
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return auth;
    }
}