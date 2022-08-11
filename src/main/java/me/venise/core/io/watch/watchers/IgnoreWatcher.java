package me.venise.core.io.watch.watchers;

import me.venise.core.io.watch.Watcher;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 *
 * 跳过所有事件处理Watcher<br>
 * 用户继承此类后实现需要监听的方法
 * @author liangweijie
 *  email kodey@venise.me
 * @date 2022/7/29 15:13
 */
public class IgnoreWatcher implements Watcher {

    @Override
    public void onCreate(WatchEvent<?> event, Path currentPath) {
    }

    @Override
    public void onModify(WatchEvent<?> event, Path currentPath) {
    }

    @Override
    public void onDelete(WatchEvent<?> event, Path currentPath) {
    }

    @Override
    public void onOverflow(WatchEvent<?> event, Path currentPath) {
    }
}