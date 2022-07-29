package me.venise.core.net;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 16:22
 */
public class DefaultTrustManager implements X509TrustManager {

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
    }
}