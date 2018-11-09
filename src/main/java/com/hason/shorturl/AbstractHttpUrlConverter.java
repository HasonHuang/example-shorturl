package com.hason.shorturl;

import com.hason.shorturl.util.ExceptionUtil;
import com.hason.shorturl.http.HttpClientUtil;
import com.hason.shorturl.http.builder.HCB;
import com.hason.shorturl.http.common.HttpConfig;
import com.hason.shorturl.http.common.HttpHeader;
import com.hason.shorturl.http.common.HttpMethod;
import com.hason.shorturl.http.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;

/**
 * URL 转换器的抽象骨架类，基于 Apache HttpClient + JSON 实现第三方接口转换短网址
 *
 * @date 2018/6/13
 */
public abstract class AbstractHttpUrlConverter implements UrlConverter {

    /** 连接数 */
    private static final int MAX_POOL_SIZE = 100;

    /** 客户端 */
    private HttpClient client;

    private static final String METHOD = HttpMethod.GET.getName();

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private static final Header[] HEADERS
            = HttpHeader.custom().contentType(CONTENT_TYPE).build();

    protected AbstractHttpUrlConverter() {
        try {
            client = HCB.custom()
                    .ssl()
                    .pool(MAX_POOL_SIZE, MAX_POOL_SIZE)
                    .build();
        } catch (HttpProcessException e) {
            throw ExceptionUtil.unchecked(e);
        }
    }

    @Override
    public String shorten(String longUrl) {
        try {
            return HttpClientUtil.send(shortenConfig(longUrl));
        } catch (HttpProcessException e) {
            throw ExceptionUtil.unchecked(e);
        }
    }

    @Override
    public String lengthen(String shortUrl) {
        try {
            return HttpClientUtil.send(lengthenConfig(shortUrl));
        } catch (HttpProcessException e) {
            throw ExceptionUtil.unchecked(e);
        }
    }

    /**
     * 生成缩短网址的 HTTP API 请求配置
     *
     * @param url 待缩短的网址
     * @return HttpConfig
     */
    protected HttpConfig shortenConfig(String url) {
        return HttpConfig.custom()
                .url(getShortenUri(url))
                .client(client)
                .methodName(getShortenMethod())
                .headers(getShortenHeaders())
                .json(getShortenRequestBody(url));
    }

    /**
     * 生成还原网址的 HTTP API 请求配置
     *
     * @param url 待缩短的网址
     * @return HttpConfig
     */
    protected HttpConfig lengthenConfig(String url) {
        return HttpConfig.custom()
                .url(getLengthenUri(url))
                .client(client)
                .methodName(getLengthMethod())
                .headers(getLengthHeaders())
                .json(getLengthenRequestBody(url));
    }

    /**
     * 获取缩短网址的 API URI
     */
    protected abstract String getShortenUri(String shortUrl);

    /**
     * 获取还原网址的 API URI
     */
    protected abstract String getLengthenUri(String longUrl);

    /**
     * 缩短网址 API 的请求方法
     */
    protected String getShortenMethod() {
        return METHOD;
    }

    /**
     * 缩短网址 API 的请求头
     */
    protected Header[] getShortenHeaders() {
        return HEADERS;
    }

    /**
     * 缩短网址 API 的请求体
     */
    protected String getShortenRequestBody(String shortUrl) {
        return null;
    }

    /**
     * 还原网址 API 的请求体
     */
    protected String getLengthMethod() {
        return METHOD;
    }

    /**
     * 还原网址 API 的请求头
     */
    protected Header[] getLengthHeaders() {
        return HEADERS;
    }

    /**
     * 还原网址 API 的请求体
     */
    protected String getLengthenRequestBody(String longUrl) {
        return null;
    }

    /**
     * 设置 HTTP 客户端
     */
    public void setClient(HttpClient client) {
        this.client = client;
    }

    /**
     * 获取 HTTP 客户端
     */
    public HttpClient getClient() {
        return client;
    }
}
