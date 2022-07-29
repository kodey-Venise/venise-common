package me.venise.core.thread;

import java.util.concurrent.ExecutorService;

/**
 *
 * 保证ExecutorService在对象回收时正常结束
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/29 15:31
 */
public class FinalizableDelegatedExecutorService extends DelegatedExecutorService {

    /**
     * 构造
     *
     * @param executor {@link ExecutorService}
     */
    FinalizableDelegatedExecutorService(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected void finalize() {
        super.shutdown();
    }
}
