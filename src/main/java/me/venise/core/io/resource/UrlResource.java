package me.venise.core.io.resource;

import me.venise.core.io.FileUtil;
import me.venise.core.util.ObjectUtil;
import me.venise.core.util.URLUtil;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

/**
 * @author liangweijie
 * @email kodey@venise.me
 * @date 2022/7/28 14:44
 */
public class UrlResource implements Resource, Serializable {
    private static final long serialVersionUID = -3499280407178572407L;
    protected URL url;
    protected String name;

    //-------------------------------------------------------------------------------------- Constructor start
    /**
     * 构造
     * @param url URL
     */
    public UrlResource(URL url) {
        this(url, null);
    }

    /**
     * 构造
     * @param url URL，允许为空
     * @param name 资源名称
     */
    public UrlResource(URL url, String name) {
        this.url = url;
        this.name = ObjectUtil.defaultIfNull(name, (null != url) ? FileUtil.getName(url.getPath()) : null);
    }

    /**
     * 构造
     * @param file 文件路径
     * @deprecated Please use {@link FileResource}
     */
    @Deprecated
    public UrlResource(File file) {
        this.url = URLUtil.getURL(file);
    }
    //-------------------------------------------------------------------------------------- Constructor end

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public URL getUrl(){
        return this.url;
    }

    @Override
    public InputStream getStream() throws NoResourceException{
        if(null == this.url){
            throw new NoResourceException("Resource URL is null!");
        }
        return URLUtil.getStream(url);
    }

    /**
     * 获得File
     * @return {@link File}
     */
    public File getFile(){
        return FileUtil.file(this.url);
    }

    /**
     * 返回路径
     * @return 返回URL路径
     */
    @Override
    public String toString() {
        return (null == this.url) ? "null" : this.url.toString();
    }
}