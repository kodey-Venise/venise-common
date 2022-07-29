package me.venise.core.lang;

import me.venise.core.clone.CloneSupport;

import java.io.Serializable;
import java.util.Objects;

/**
 * 键值对对象，只能在构造时传入键值
 *
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/22 16:01
 */
public class Pair<K,V> extends CloneSupport<Pair<K,V>> implements Serializable {

    private static final long serialVersionUID = 5766865261735740229L;

    private final K key;
    private final V value;

    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }


    public static <K,V> Pair<K,V> of(K key,V value){
        return new Pair<>(key,value);
    }

    public V getValue(){
        return this.value;
    }

    public K getKey(){
        return this.key;
    }

    @Override
    public String toString(){
        return "Pair [key=" + key +", value=" +value +"]";
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Pair){
            Pair<?,?> pair = (Pair<?, ?>) o;
            return Objects.equals(getKey(),pair.getKey())&&Objects.equals(getValue(),pair.getValue());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
}
