package me.venise.core.io;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/28 14:49
 */
public interface LineHandler {
    /**
     * 处理一行数据，可以编辑后存入指定地方
     * @param line 行
     */
    void handle(String line);
}

