package me.venise.core.lang;

import me.venise.core.lang.func.Func;
import me.venise.core.lang.func.Functions;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/27 14:18
 */
public class SimpleCache <K,V> implements Iterable<Map.Entry<K,V>>, Serializable {

    private static final long serialVersionUID = -7320020986472578978L;

    /**
     * 池
     */
    private final Map<K,V> cache;
    /**
     * 乐观读写锁
     */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 每个KEY一把锁，降低锁的颗粒度
     */
    protected final Map<K, Lock> keyLockMap = new ConcurrentHashMap<>();

    /**
     * 构造函数
     * 通过自定义Map初始化，可以自定义缓存实现
     * 比如使用{@link WeakHashMap} 则会自动清理key，使用HashMap则不会清理
     * 同时传入的Map对象也可以自带初始化的键值对，方式在get时创建
     */
    public SimpleCache(){
        this(new WeakHashMap<>());
    }
    public SimpleCache(Map<K,V> initMap){
        this.cache = initMap;
    }

    /**
     * 从缓存持中查找值
     * @param key
     * @return
     */
    public V get(K key){
        lock.readLock().lock();
        try {
            return cache.get(key);
        }finally {
            lock.readLock().unlock();
        }
    }

    public V get(K key, Functions<V> supplier){
        V v = get(key);
        if(null==v && null!=supplier){
            final Lock keyLock = keyLockMap.computeIfAbsent(key,k->new ReentrantLock());
            keyLock.lock();
            try {
                //双重锁检查，防止在净增锁的过程中已经有其它线程写入
                v = cache.get(key);
                if(null ==v){
                    try {
                        v = supplier.call();
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    put(key,v);
                }
            }finally {
                keyLock.unlock();
                keyLockMap.remove(key);
            }
        }
        return v;
    }

    public V put(K key,V value){
        lock.writeLock().lock();;
        try {
            cache.put(key,value);
        }finally {
            lock.writeLock().unlock();
        }
        return value;
    }

    public V remove(K key){
        lock.writeLock().lock();
        try {
            return cache.remove(key);
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void clear(){
        lock.writeLock().lock();
        try {
            this.cache.clear();
        }finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Iterator<Map.Entry<K,V>> iterator(){return this.cache.entrySet().iterator();}
}
