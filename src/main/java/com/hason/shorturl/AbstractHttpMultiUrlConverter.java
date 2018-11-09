package com.hason.shorturl;

import com.hason.shorturl.http.HttpClientUtil;
import com.hason.shorturl.http.common.HttpConfig;
import com.hason.shorturl.http.exception.HttpProcessException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * URL 转换器的抽象骨架类，支持同时转换多个 URL
 *
 * 基于 Apache HttpClient + JSON 实现第三方接口转换短网址
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/15
 */
public abstract class AbstractHttpMultiUrlConverter extends AbstractHttpUrlConverter
        implements MultiUrlConverter {

    @Override
    public Map<String, String> shorten(Collection<String> longUrls) {
        try {
            return handleShorten(HttpClientUtil.send(shortenConfig(longUrls)));
        } catch (HttpProcessException e) {
            throw new UrlConvertException("调用 API 缩短网址失败", e);
        }
    }

    @Override
    public Map<String, String> lengthen(Collection<String> shortUrls) {
        try {
            return handleLengthen(HttpClientUtil.send(lengthenConfig(shortUrls)));
        } catch (HttpProcessException e) {
            throw new UrlConvertException("调用 API 还原网址失败", e);
        }
    }

    @Override
    public String shorten(String longUrl) {
        return shorten(Collections.singleton(longUrl)).get(longUrl);
    }

    @Override
    public String lengthen(String shortUrl) {
        return lengthen(Collections.singleton(shortUrl)).get(shortUrl);
    }

    @Override
    protected String getShortenUri(String shortUrl) {
        return getShortenUri(Collections.singleton(shortUrl));
    }

    @Override
    protected String getLengthenUri(String longUrl) {
        return getLengthenUri(Collections.singleton(longUrl));
    }

    /**
     * 获取缩短网址 API 的地址
     * 此方法会被 {@link #shortenConfig(Collection)} 调用
     *
     * @param longUrls 待缩短网址列表
     * @return API 地址
     */
    protected abstract String getShortenUri(Collection<String> longUrls);

    /**
     * 获取还原网址 API 的地址
     * 此方法会被 {@link #lengthenConfig(Collection)} 调用
     *
     * @param shortUrls 待还原网址列表
     * @return API 地址
     */
    protected abstract String getLengthenUri(Collection<String> shortUrls);

    /**
     * 请求缩短网址 API 的请求体
     * 此方法会被 {@link #shortenConfig(Collection)} 调用
     *
     * @param longUrls 待缩短网址列表
     * @return API 地址
     */
    protected String getShortenRequestBody(Collection<String> longUrls) {
        return null;
    }

    /**
     * 请求还原网址 API 的请求体
     * 此方法会被 {@link #lengthenConfig(Collection)} 调用
     *
     * @param shortUrls 待还原网址列表
     * @return API 地址
     */
    protected String getLengthenRequestBody(Collection<String> shortUrls) {
        return null;
    }

    /**
     * 处理 API 返回内容并返回 Map 结构的抽象模板方法。
     * 此方法会被 {@link #shorten(Collection)} 调用
     *
     * @param result HTTP API 返回内容
     * @return map
     */
    protected abstract Map<String, String> handleShorten(String result);

    /**
     * 处理 API 返回内容并返回 Map 结构的抽象模板方法。
     * 此方法会被 {@link #lengthen(Collection)} 调用
     *
     * @param result HTTP API 返回内容
     * @return map
     */
    protected abstract Map<String, String> handleLengthen(String result);

    /**
     * 缩短网址的请求配置
     *
     * @param longUrls 待缩短网址列表
     * @return HttpConfig
     */
    protected HttpConfig shortenConfig(Collection<String> longUrls) {
        return HttpConfig.custom()
                .url(getShortenUri(longUrls))
                .client(getClient())
                .methodName(getShortenMethod())
                .headers(getShortenHeaders())
                .json(getShortenRequestBody(longUrls));
    }

    /**
     * 还原网址的请求配置
     *
     * @param shortUrls 待还原网址列表
     * @return HttpConfig
     */
    protected HttpConfig lengthenConfig(Collection<String> shortUrls) {
        return HttpConfig.custom()
                .url(getLengthenUri(shortUrls))
                .client(getClient())
                .methodName(getLengthMethod())
                .headers(getLengthHeaders())
                .json(getLengthenRequestBody(shortUrls));
    }

}
