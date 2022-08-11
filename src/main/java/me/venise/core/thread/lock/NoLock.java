package me.venise.core.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 14:16
 */
public class NoLock implements Lock {

    @Override
    public void lock() {
    }

    @Override
    public void lockInterruptibly() {
    }

    @Override
    public boolean tryLock() {
        return true;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        return true;
    }

    @Override
    public void unlock() {
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("NoLock`s newCondition method is unsupported");
    }

}
