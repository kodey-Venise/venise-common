package me.venise.core.net;

import me.venise.core.io.IORuntimeException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 16:21
 */
public class SSLUtil {

    /**
     * 创建{@link SSLContext}
     *
     * @param protocol     SSL协议，例如TLS等
     * @param keyManager   密钥管理器,{@code null}表示无
     * @param trustManager 信任管理器, {@code null}表示无
     * @return {@link SSLContext}
     * @throws IORuntimeException 包装 GeneralSecurityException异常
     */
    public static SSLContext createSSLContext(String protocol, KeyManager keyManager, TrustManager trustManager)
            throws IORuntimeException {
        return createSSLContext(protocol,
                keyManager == null ? null : new KeyManager[]{keyManager},
                trustManager == null ? null : new TrustManager[]{trustManager});
    }

    /**
     * 创建和初始化{@link SSLContext}
     *
     * @param protocol      SSL协议，例如TLS等
     * @param keyManagers   密钥管理器,{@code null}表示无
     * @param trustManagers 信任管理器, {@code null}表示无
     * @return {@link SSLContext}
     * @throws IORuntimeException 包装 GeneralSecurityException异常
     */
    public static SSLContext createSSLContext(String protocol, KeyManager[] keyManagers, TrustManager[] trustManagers) throws IORuntimeException {
        return SSLContextBuilder.create()
                .setProtocol(protocol)
                .setKeyManagers(keyManagers)
                .setTrustManagers(trustManagers).buildQuietly();
    }

}