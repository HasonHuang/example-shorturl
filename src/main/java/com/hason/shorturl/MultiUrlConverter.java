package com.hason.shorturl;

import java.util.Collection;
import java.util.Map;

/**
 * 短网址转换器，支持多个网址转换
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/15
 */
public interface MultiUrlConverter extends UrlConverter {

    /**
     * 缩短网址
     *
     * @param longUrls 待缩短的网址集合
     * @return 缩短结果，以入参的网址为 key，转换结果为 value 创建映射结果。
     *         {key: longUrl, value: Result}
     * @throws UrlConvertException 如果失败抛出此异常
     */
    Map<String, String> shorten(Collection<String> longUrls);

    /**
     * 还原网址
     *
     * @param shortUrls 短网址集合
     * @return 还原结果， 以短网址为 key，还原结果为 value 创建映射结果。
     *         {key: shortUrl, value: Result}
     * @throws UrlConvertException 如果失败抛出此异常
     */
    Map<String, String> lengthen(Collection<String> shortUrls);

}
