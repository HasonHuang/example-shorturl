package com.hason.shorturl;

/**
 * 短网址转换器
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/12
 */
public interface UrlConverter {

    /**
     * 缩短网址
     *
     * @param longUrl 待缩短的网址
     * @return 缩短结果
     * @throws UrlConvertException 如果失败抛出此异常
     */
    String shorten(String longUrl);

    /**
     * 还原网址
     *
     * @param shortUrl 短网址
     * @return 还原结果
     * @throws UrlConvertException 如果失败抛出此异常
     */
    String lengthen(String shortUrl);

}
