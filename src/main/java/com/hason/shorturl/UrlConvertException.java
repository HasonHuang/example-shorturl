package com.hason.shorturl;

/**
 * 短网址转换异常
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/15
 */
public class UrlConvertException extends RuntimeException {
    public UrlConvertException(String message) {
        super(message);
    }

    public UrlConvertException(String message, Throwable cause) {
        super(message, cause);
    }
}
